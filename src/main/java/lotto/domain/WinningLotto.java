package lotto.domain;

public class WinningLotto {

    public static final String DUPLICATE_NUM_EXIST = "중복된 로또 숫자가 존재합니다.";

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if(lottoNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_NUM_EXIST);
        }
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
