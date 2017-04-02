package simple.blog.app.entity;

import java.sql.Date;

public class SсheduleRecord {
    private Integer idRecord;
    private Integer idRoom;
    private Integer idRequest;
    private Date checkinDate;
    private Date checkoutDate;

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Integer getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SсheduleRecord that = (SсheduleRecord) o;

        if (idRecord != null ? !idRecord.equals(that.idRecord) : that.idRecord != null) return false;
        if (idRoom != null ? !idRoom.equals(that.idRoom) : that.idRoom != null) return false;
        if (idRequest != null ? !idRequest.equals(that.idRequest) : that.idRequest != null) return false;
        if (checkinDate != null ? !checkinDate.equals(that.checkinDate) : that.checkinDate != null) return false;
        if (checkoutDate != null ? !checkoutDate.equals(that.checkoutDate) : that.checkoutDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecord != null ? idRecord.hashCode() : 0;
        result = 31 * result + (idRoom != null ? idRoom.hashCode() : 0);
        result = 31 * result + (idRequest != null ? idRequest.hashCode() : 0);
        result = 31 * result + (checkinDate != null ? checkinDate.hashCode() : 0);
        result = 31 * result + (checkoutDate != null ? checkoutDate.hashCode() : 0);
        return result;
    }
}
