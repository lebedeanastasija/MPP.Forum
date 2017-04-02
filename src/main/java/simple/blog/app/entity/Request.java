package simple.blog.app.entity;

import java.sql.Date;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Request {
    private Integer idRequest;
    private Integer idClient;
    private Integer idAdministrator;
    private Byte seatsNumber;
    private Date checkinDate;
    private Byte daysStay;
    private Byte requestType;
    private Integer payment;
    private Byte requestStatus;

    public Integer getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(Integer idRequest) {
        this.idRequest = idRequest;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public Byte getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Byte seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Byte getDaysStay() {
        return daysStay;
    }

    public void setDaysStay(Byte daysStay) {
        this.daysStay = daysStay;
    }

    public Byte getRequestType() {
        return requestType;
    }

    public void setRequestType(Byte requestType) {
        this.requestType = requestType;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Byte getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Byte requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (idRequest != null ? !idRequest.equals(request.idRequest) : request.idRequest != null) return false;
        if (idClient != null ? !idClient.equals(request.idClient) : request.idClient != null) return false;
        if (idAdministrator != null ? !idAdministrator.equals(request.idAdministrator) : request.idAdministrator != null)
            return false;
        if (seatsNumber != null ? !seatsNumber.equals(request.seatsNumber) : request.seatsNumber != null) return false;
        if (checkinDate != null ? !checkinDate.equals(request.checkinDate) : request.checkinDate != null) return false;
        if (daysStay != null ? !daysStay.equals(request.daysStay) : request.daysStay != null) return false;
        if (requestType != null ? !requestType.equals(request.requestType) : request.requestType != null) return false;
        if (payment != null ? !payment.equals(request.payment) : request.payment != null) return false;
        if (requestStatus != null ? !requestStatus.equals(request.requestStatus) : request.requestStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRequest != null ? idRequest.hashCode() : 0;
        result = 31 * result + (idClient != null ? idClient.hashCode() : 0);
        result = 31 * result + (idAdministrator != null ? idAdministrator.hashCode() : 0);
        result = 31 * result + (seatsNumber != null ? seatsNumber.hashCode() : 0);
        result = 31 * result + (checkinDate != null ? checkinDate.hashCode() : 0);
        result = 31 * result + (daysStay != null ? daysStay.hashCode() : 0);
        result = 31 * result + (requestType != null ? requestType.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (requestStatus != null ? requestStatus.hashCode() : 0);
        return result;
    }
}
