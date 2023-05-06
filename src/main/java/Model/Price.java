package Model;

import java.text.DecimalFormat;

public class Price {
    private int price;

    public Price(int price) {
        this.price = price;
    }

    public int getCount(int amount) {
        return amount / this.price;
    }

}
