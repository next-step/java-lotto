package lotto.domain;

public class WinningLotto {

    public static final String DUPLICATE_NUM_EXIST = "중복된 로또 숫자가 존재합니다.";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_NUM_EXIST);
        }
    }

    public Lotto getLottoNumbers() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
