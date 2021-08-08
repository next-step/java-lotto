package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;
    private Award award = Award.UNIDENTIFIED;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void drawLotto(LottoNumbers winnerNumbers) {
        award = Award.findBy(lottoNumbers.countContains(winnerNumbers));
    }

    public boolean isWinner(Award award) {
        return this.award == award;
    }

    public Award getAward() {
        return award;
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }
}
