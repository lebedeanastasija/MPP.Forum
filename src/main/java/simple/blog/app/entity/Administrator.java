package simple.blog.app.entity;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Administrator {
    private Integer idAdministrator;
    private String login;
    private String password;
    private Integer idPassport;

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator that = (Administrator) o;

        if (idAdministrator != null ? !idAdministrator.equals(that.idAdministrator) : that.idAdministrator != null)
            return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (idPassport != null ? !idPassport.equals(that.idPassport) : that.idPassport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAdministrator != null ? idAdministrator.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (idPassport != null ? idPassport.hashCode() : 0);
        return result;
    }
}
