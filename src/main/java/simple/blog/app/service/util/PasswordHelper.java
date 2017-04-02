package simple.blog.app.service.util;

import org.apache.log4j.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordHelper {
    private static final Logger logger = Logger.getLogger(PasswordHelper.class);
    private static final PasswordHelper INSTANCE = new PasswordHelper();
    private static final String ENCRYPT_ALGORITHM = "SHA-512";
    private static final String SALT_ALGORITHM = "SHA1PRNG";
    private static final int SALT_SIZE = 16;

    private PasswordHelper() {
    }

    public static PasswordHelper getInstance() {
        return INSTANCE;
    }

    public byte[] encryptPassword(byte[] password) {
        return encryptPassword(password, getSalt());
    }

    private byte[] encryptPassword(byte[] password, byte[] salt) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ENCRYPT_ALGORITHM);
            messageDigest.update(salt);
            byte[] bytes = messageDigest.digest(password);
            byte[] generatedPassword = new byte[bytes.length + salt.length];
            System.arraycopy(salt, 0, generatedPassword, 0, salt.length);
            for (int i = 0; i < bytes.length; i++) {
                generatedPassword[salt.length + i] = (byte) ((bytes[i] & 0xFF) + 0x100);
            }
            PasswordHelper.dispose(bytes, password, salt);
            return generatedPassword;

        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }

        return null;
    }

    private byte[] getSalt() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(SALT_ALGORITHM);
            byte[] salt = new byte[SALT_SIZE];
            secureRandom.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }

        return null;
    }

    public boolean match(byte[] password, byte[] hashedPassword) {
        byte[] salt = new byte[SALT_SIZE];
        System.arraycopy(hashedPassword, 0, salt, 0, SALT_SIZE);

        byte[] generatedPassword = encryptPassword(password, salt);
        boolean match = Arrays.equals(generatedPassword, hashedPassword);
        PasswordHelper.dispose(generatedPassword, hashedPassword);

        return match;
    }

    public static void dispose(byte[]... arrays) {
        for (byte[] password : arrays) {
            if (password != null) {
                Arrays.fill(password, (byte) 0);
            }
        }
    }
}
