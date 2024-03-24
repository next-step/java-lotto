package lotto.domain;

public class Price {
    public int price;

    public Price(int price){
        checkPrice(price);
        this.price = price;
    }

    private void checkPrice(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000배수");
        }
    }

}
