package simple.blog.app.entity;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Card {
    private Integer idCard;
    private Integer idClient;
    private Integer totalSum;
    private Integer idDiscount;

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (idCard != null ? !idCard.equals(card.idCard) : card.idCard != null) return false;
        if (idClient != null ? !idClient.equals(card.idClient) : card.idClient != null) return false;
        if (totalSum != null ? !totalSum.equals(card.totalSum) : card.totalSum != null) return false;
        if (idDiscount != null ? !idDiscount.equals(card.idDiscount) : card.idDiscount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCard != null ? idCard.hashCode() : 0;
        result = 31 * result + (idClient != null ? idClient.hashCode() : 0);
        result = 31 * result + (totalSum != null ? totalSum.hashCode() : 0);
        result = 31 * result + (idDiscount != null ? idDiscount.hashCode() : 0);
        return result;
    }
}
