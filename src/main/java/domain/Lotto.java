package domain;

import java.util.List;

import domain.type.LottoRankResult;

public class Lotto {
    private LottoNumbers lottoNumber;

    private LottoRankResult lottoRankAmount;

    public Lotto() {
        this.lottoNumber = LottoNumbers.createAutoLottoNumbers();
    }

    public Lotto(List<String> input) {
        this.lottoNumber = LottoNumbers.createManualLottoNumbers(input);
    }

    public Lotto(String input) {
        this.lottoNumber = new LottoNumbers(input);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumber;
    }

    public LottoRankResult calculateLottoRank(FirstPlaceLotto firstPlaceLotto) {
        return LottoRank.getRank(this, firstPlaceLotto);
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumber.getNumbers().stream()
                .filter(it -> lotto.getLottoNumbers().getNumbers().contains(it))
                .count();
    }

    public boolean hasBonusNumer(FirstPlaceLotto firstPlaceLotto) {
        return lottoNumber.getNumbers().stream()
                .filter(it -> it.equals(firstPlaceLotto.getBonusLottoNumber()))
                .count() > 0;
    }

}
