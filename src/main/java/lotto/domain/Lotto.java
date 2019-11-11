package lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank matchTo(WinningLotto winningLotto) {
        boolean matchBonusNumber = winningLotto.matchBonusNumber(getLottoNumbers());

        return LottoRank.find(
                getMatchNumberCount(winningLotto.getNumbers()),
                rank -> matchBonusNumber ? LottoRank.SECOND : LottoRank.THIRD);
    }

    private long getMatchNumberCount(LottoNumbers targetLottoNumbers) {
        return targetLottoNumbers
                .getValue()
                .stream()
                .filter(lottoNumbers.getValue()::contains)
                .count();
    }
}
