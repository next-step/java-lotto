package domain;

public class Lotto {
    private LottoNumbers lotto;

    public Lotto(LottoNumbers lottoNumber) {
        this.lotto = lottoNumber;
    }

    public boolean isContains(LottoNo winningNumber) {
        return lotto.isContains(winningNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

}
