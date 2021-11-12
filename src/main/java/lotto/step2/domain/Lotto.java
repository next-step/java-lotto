package lotto.step2.domain;

import java.util.List;

public class Lotto {

    private Price price;
    private Number number;

    // 테스트 생성자
    public Lotto(Number number) {
        this.number = number;
    }

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

    public int getMatch(List<Integer> winningNumber) {
        int count = 0;
        List<Integer> number = this.number.getNumber();
        for (int w : winningNumber) {
            if (number.contains(w)) {
                count++;
            }
        }
        return count;

    }

    @Override
    public String toString() {
        return "" + number;
    }
}
