package lotto.domain;

public final class WiningLotto {

    private final LottoNumbers winingLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WiningLotto(final LottoNumbers winingLottoNumbers, final LottoNumber bonusLottoNumber) {
        this.winingLottoNumbers = winingLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoResult computeLottoResult(final LottoNumbers lottoNumbers) {
        return LottoResult.valueOf(
            lottoNumbers.matchTo(winingLottoNumbers),
            lottoNumbers.contains(bonusLottoNumber));
    }
}
