package simple.blog.app.entity;

import java.sql.Date;

public class Passport {
    private Integer idPassport;
    private Integer passportNumber;
    private String series;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;

    public Integer getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(Integer idPassport) {
        this.idPassport = idPassport;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Integer passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (idPassport != null ? !idPassport.equals(passport.idPassport) : passport.idPassport != null) return false;
        if (passportNumber != null ? !passportNumber.equals(passport.passportNumber) : passport.passportNumber != null)
            return false;
        if (series != null ? !series.equals(passport.series) : passport.series != null) return false;
        if (surname != null ? !surname.equals(passport.surname) : passport.surname != null) return false;
        if (name != null ? !name.equals(passport.name) : passport.name != null) return false;
        if (patronymic != null ? !patronymic.equals(passport.patronymic) : passport.patronymic != null) return false;
        if (birthday != null ? !birthday.equals(passport.birthday) : passport.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPassport != null ? idPassport.hashCode() : 0;
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
