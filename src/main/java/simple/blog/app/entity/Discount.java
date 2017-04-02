package simple.blog.app.entity;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class Discount {
    private Integer idDiscount;
    private Integer minSum;
    private Integer maxSum;
    private Integer discountValue;

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
    }

    public Integer getMinSum() {
        return minSum;
    }

    public void setMinSum(Integer minSum) {
        this.minSum = minSum;
    }

    public Integer getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(Integer maxSum) {
        this.maxSum = maxSum;
    }

    public Integer getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        if (idDiscount != null ? !idDiscount.equals(discount.idDiscount) : discount.idDiscount != null) return false;
        if (minSum != null ? !minSum.equals(discount.minSum) : discount.minSum != null) return false;
        if (maxSum != null ? !maxSum.equals(discount.maxSum) : discount.maxSum != null) return false;
        if (discountValue != null ? !discountValue.equals(discount.discountValue) : discount.discountValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDiscount != null ? idDiscount.hashCode() : 0;
        result = 31 * result + (minSum != null ? minSum.hashCode() : 0);
        result = 31 * result + (maxSum != null ? maxSum.hashCode() : 0);
        result = 31 * result + (discountValue != null ? discountValue.hashCode() : 0);
        return result;
    }
}
