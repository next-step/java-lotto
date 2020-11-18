package lotto.domain;

public class Lotto {

    public static final int PRICE = 1000;

    private LottoNumber number;

    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public int getMatchedNumberCount(NumberMatcher numberMatcher) {
        return number.getMatchedNumberCount(numberMatcher);
    }
}
