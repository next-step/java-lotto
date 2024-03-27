package lotto;


public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    public Rank match(LottoNumbers winNums, BonusNumber bonusNumber) {
        return Rank.getRank(lottoNumbers.matchNumberCount(winNums), bonusNumber.match(lottoNumbers.getNumbers()));
    }

}
