package lotto.step2;

public class Lotto {

    private Price price;
    private Number number;

    public Lotto() {
        this.number = new Number();
    }

    public Lotto(int price) {
        this.price = new Price(price);
    }

    public Number getLottoNumber() {
        return number;
    }

    public Price getLottoPrice() {
        return price;
    }
}
