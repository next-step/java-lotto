package domain;

import java.util.List;

import domain.type.LottoRankResult;

public class Lotto {
    private LottoNumbers lottoNumber;
    private LottoRankResult lottoRankAmount;

    public Lotto() {
        this.lottoNumber = new LottoNumbers();
    }

    public Lotto(List<String> input) {
        this.lottoNumber = new LottoNumbers(input);
    }

    public Lotto(String input) {
        this.lottoNumber = new LottoNumbers(input);
    }

    public LottoRankResult getLottoRankAmount() {
        return lottoRankAmount;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumber;
    }

    public void calculateLottoRank(FirstPlaceLotto firstPlaceLotto) {
        lottoRankAmount = LottoRank.getRank(this, firstPlaceLotto);
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumber.getNumbers().stream()
                .filter(it -> lotto.getLottoNumbers().getNumbers().contains(it))
                .count();
    }

    public boolean isHaveBonusNumer(FirstPlaceLotto firstPlaceLotto) {
        return lottoNumber.getNumbers().stream()
                .filter(it -> it.equals(firstPlaceLotto.getBonusLottoNumber()))
                .count() > 0;
    }

}
