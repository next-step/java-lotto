package lotto;

public class Price {
    public int price;

    public Price(int price){
        this.price = checkPrice(price);
    }

    private int checkPrice(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("금액은 1000배수");
        }
        return price;
    }

}
