package lotto;

public class Lotto {

    private LottoNumber number;

    public Lotto(LottoNumber number){
        this.number = number;
    }

    public int getMatchedNumberCount(NumberMatcher numberMatcher) {
        return number.getMatchedNumberCount(numberMatcher);
    }
}
