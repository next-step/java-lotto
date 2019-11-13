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
        return LottoRank.find(
                getMatchNumberCount(winningLotto.getNumbers()),
                winningLotto.matchBonusNumber(getLottoNumbers())
        );
    }

    private long getMatchNumberCount(LottoNumbers targetLottoNumbers) {
        return targetLottoNumbers
                .getValue()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }
}
