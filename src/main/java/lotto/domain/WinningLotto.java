package lotto.domain;

import calculator.InvalidInputException;

public class WinningLotto {
    private static final String INVALID_BONUS_BALL_MESSAGE = "당첨볼에 보너스볼과 중복된 번호가 있습니다.";

    private Lotto winningLotto;
    private LottoNumber bonusLottoNumber;

    public WinningLotto(String lottoNumbers, String bonusNumber) {
        winningLotto = Lotto.of(lottoNumbers);
        bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (winningLotto.getLottoNumbers().stream().anyMatch(num -> num.equals(bonusLottoNumber))) {
            throw new InvalidInputException(INVALID_BONUS_BALL_MESSAGE);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusLottoNumber;
    }

}
