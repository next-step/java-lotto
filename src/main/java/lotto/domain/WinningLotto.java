package lotto.domain;

public class WinningLotto {

    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "당첨번호와 보너스번호가 중복되었습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if(winningLotto.getLottoNumbers().contains(bonusNumber)) { // refactor
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    // 랭킹집계

}
