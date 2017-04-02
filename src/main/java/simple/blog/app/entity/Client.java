package simple.blog.app.entity;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Client {
    private Integer idClient;
    private String login;
    private String password;
    private Integer idPassport;
    private Byte banned;

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Integer idPassport) {
        this.idPassport = idPassport;
    }

    public Byte getBanned() {
        return banned;
    }

    public void setBanned(Byte banned) {
        this.banned = banned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != null ? !idClient.equals(client.idClient) : client.idClient != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (idPassport != null ? !idPassport.equals(client.idPassport) : client.idPassport != null) return false;
        if (banned != null ? !banned.equals(client.banned) : client.banned != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient != null ? idClient.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (idPassport != null ? idPassport.hashCode() : 0);
        result = 31 * result + (banned != null ? banned.hashCode() : 0);
        return result;
    }
}
