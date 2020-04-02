package lotto.domain;

public class WinningLottoNumbers {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber lottoNumber;

    private WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 숫자가 포함되면 안된다.");
        }
        this.lottoNumbers = lottoNumbers;
        this.lottoNumber = lottoNumber;
    }

    public static WinningLottoNumbers valueOf(LottoNumbers lottoNumbers, LottoNumber lottoNumber) {
        return new WinningLottoNumbers(lottoNumbers, lottoNumber);
    }

    LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
