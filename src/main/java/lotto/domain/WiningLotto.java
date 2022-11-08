package lotto.domain;

public final class WiningLotto {

    private final LottoNumbers winingLottoNumbers;

    public WiningLotto(final LottoNumbers winingLottoNumbers) {
        this.winingLottoNumbers = winingLottoNumbers;
    }

    public LottoResult computeLottoResult(final LottoNumbers lottoNumbers) {
        return LottoResult.valueOf(winingLottoNumbers.matchTo(lottoNumbers));
    }
}
