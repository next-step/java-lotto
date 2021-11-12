package lotto.step2.domain;

public class Lotto {

    private Price price;
    private Number number;

    public Lotto(int price) {
        this.price = new Price(price);
        this.number = new Number();
    }

    public Number getLottoNumber() {
        return number;
    }

    public Price getLottoPrice() {
        return price;
    }

}
