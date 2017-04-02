package simple.blog.app.service.util;

import simple.blog.app.entity.RequestEntity;
import simple.blog.app.entity.SсheduleRecordEntity;

import java.nio.CharBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
import java.util.Date;

import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String LOGIN_REGEXP = "^[a-zA-Z][a-zA-Z0-9_]{4,39}$";
    private static final String PASSWORD_REGEXP = "(?=^.{6,45}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    private static final String PASSPORT_SERIES_REGEXP = "^[A-Z]{2}$";
    private static final String NAME_REGEXP = "^[a-zA-Zа-яёА-ЯЁ\\s\\-]{2,40}$";
    private static final String DATE_REGEXP = "(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)";

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String BIRTHDAY_DATE_MAX = "1999-01-01";
    private static final String BIRTHDAY_DATE_MIN = "1919-12-31";

    private static final int MAX_DISCOUNT_VALUE = 1000;
    private static final int MAX_ROOM_NUMBER = 1000;
    private static final int MAX_PER_DAY_COST = 100;
    private static final int MAX_SEATS_NUMBER = 5;
    private static final int MAX_DAYS_STAY_NUMBER = 31;
    private static final int MIN_PASSPORT_ID = 1000000;
    private static final int MAX_PASSPORT_ID = 9999999;

    public static boolean validateInt(int value) {
        return value > 0;
    }

    public static boolean validateStart(int value) { return value >= 0;}

    public static boolean validateString(String value) {
        return !(value == null || value.isEmpty());
    }

    public static boolean validateDiscountValue(int value) {
        return validateInt(value) && value <= MAX_DISCOUNT_VALUE;
    }

    public static boolean validateRoomNumber(int number) {
        return number >= 100 && number <= MAX_ROOM_NUMBER;
    }

    public static boolean validatePerdayCost(int perdayCost) {
        return perdayCost >= 10 && perdayCost <= MAX_PER_DAY_COST;
    }

    public static boolean validateLogin(String login) {
        if (!validateString(login)) {
            return false;
        }
        Pattern pattern = Pattern.compile(LOGIN_REGEXP);
        Matcher m = pattern.matcher(login);
        return m.matches();
    }

    public static boolean validatePassword(byte[] password) {
        if (password == null || password.length < 1) {
            PasswordHelper.dispose(password);
            return false;
        }
        char[] chars = new char[password.length];
        for (int i = 0; i < password.length; i++) {
            chars[i] = (char) password[i];
        }

        Pattern pattern = Pattern.compile(PASSWORD_REGEXP);
        Matcher m = pattern.matcher(CharBuffer.wrap(chars));

        boolean match = m.matches();

        if (!match) {
            PasswordHelper.dispose(password);
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = 0;
        }
        return match;
    }

    public static boolean validatePassportIdNumber(int identificationNumber) {
        return !((identificationNumber < MIN_PASSPORT_ID) || (identificationNumber > MAX_PASSPORT_ID));
    }

    public static boolean validatePassportSeries(String series) {
        if (!validateString(series)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PASSPORT_SERIES_REGEXP);
        Matcher m = pattern.matcher(series);
        return m.matches();
    }

    public static boolean validateName(String name) {
        if (!validateString(name)) {
            return false;
        }
        Pattern pattern = Pattern.compile(NAME_REGEXP);
        Matcher m = pattern.matcher(name);
        return m.matches();
    }

    public static boolean validateBirthdayDate(Date birthday) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            return validateDate(birthday) &&
                    birthday.after(format.parse(BIRTHDAY_DATE_MIN)) &&
                    birthday.before(format.parse(BIRTHDAY_DATE_MAX));
        } catch (ParseException e) {
            return false;
        }
    }

   /* public static boolean validateCheckinDate(Date date) {
        return validateDate(date) &&
                date.after(Date.from(LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC))) &&
                date.before(Date.from(LocalDateTime.now().plusYears(1).toInstant(ZoneOffset.UTC)));
    }*/

    public static boolean validateDate(Date date) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        String dateStr;
        try {
            dateStr = format.format(date);
        } catch (Exception e) {
            return false;
        }
        Pattern pattern = Pattern.compile(DATE_REGEXP);
        Matcher m = pattern.matcher(dateStr);

        return m.matches();

    }

    public static boolean validateDaysStayNumber(int daysStayNumber) {
        return validateInt(daysStayNumber) && daysStayNumber <= MAX_DAYS_STAY_NUMBER;
    }

    public static boolean validateSeatsNumber(int seatsNumber) {
        return validateInt(seatsNumber) && seatsNumber <= MAX_SEATS_NUMBER;
    }

   /* public static boolean validateScheduleRecord(SсheduleRecordEntity scheduleRecord) {
        return validateInt(scheduleRecord.getRoomNumber()) &&
                validateDate(scheduleRecord.getCheckInDate()) &&
                validateDate(scheduleRecord.getCheckoutDate());
    }*/

    /*public static boolean validateRentalRequest(SсheduleRecordEntity scheduleRecord, RentalRequest rentalRequest) {
        return validateScheduleRecord(scheduleRecord) &&
                validateInt(rentalRequest.getClient().getId()) &&
                validateDaysStayNumber(rentalRequest.getDaysStayNumber()) &&
                validateSeatsNumber(rentalRequest.getSeatsNumber()) &&
                validateCheckinDate(rentalRequest.getCheckInDate()) &&
                (rentalRequest.isFullPayment()) ?
                validateInt(rentalRequest.getPayment()) : validateInt(scheduleRecord.getPaymentDuty());
    }*/
}
