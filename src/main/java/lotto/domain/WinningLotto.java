package lotto.domain;

import calculator.InvalidInputException;

import java.util.Set;

public class WinningLotto {
    private static final String INVALID_BONUS_BALL_MESSAGE = "당첨볼에 보너스볼과 중복된 번호가 있습니다.";

    public static Set<LottoNumber> numbers;
    private LottoNumber bonusLottoNumber;

    public WinningLotto(String lottoNumbers, String bonusNumber) {
        numbers = Lotto.of(lottoNumbers).getLottoNumbers();
        bonusLottoNumber = LottoNumber.valueOf(bonusNumber);
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (numbers.stream().anyMatch(num -> num.equals(bonusLottoNumber))) {
            throw new InvalidInputException(INVALID_BONUS_BALL_MESSAGE);
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusLottoNumber;
    }

}
