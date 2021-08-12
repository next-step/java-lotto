package step4;

public class LottoPrice {
    private final int unitPrice;

    public LottoPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuote(int amount) {
        return amount * this.unitPrice;
    }

    public int getMaxQuantity(int budget) {
        if (unitPrice == 0) {
            throw new ArithmeticException();
        }

        return budget / unitPrice;
    }
}
