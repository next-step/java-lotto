package lotto.domain;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this(LottoNumberProvider.createLottoNumber());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank getRank(LottoNumbers winningLottoNumber) {
        return LottoRank.find(matchNumberCount(winningLottoNumber), matchBonusNumber(winningLottoNumber));
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private long matchNumberCount(LottoNumbers winningLottoNumber) {
        return winningLottoNumber.getNumbers()
                .stream()
                .filter(lottoNumbers.getNumbers()::contains)
                .count();
    }

    private boolean matchBonusNumber(LottoNumbers winningLottoNumber) {
        return lottoNumbers.getBonusNumber() == winningLottoNumber.getBonusNumber();
    }
}
