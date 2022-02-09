package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.util.Parser;

public class LottoResult {

    private final List<Integer> numberInput;
    private final String bonusInput;
    private final int START_NUMBER = 1;
    private final int LAST_NUMBER = 45;
    private final int LOTTO_LIMIT = 6;
    private final String WIN_BALL_INVALID = "올바른 당첨 번호 입력이 아닙니다.";
    private final String BONUS_BALL_INVALID = "올바른 보너스 볼 입력이 아닙니다.";

    public LottoResult(String numberInput, String bonusInput) {
        this.numberInput = Parser.splitInput(numberInput);
        this.bonusInput = bonusInput;
        validateWinNumbers();
        validateBonusNumber();
    }

    public int matchNumbersCount(Lotto lotto) {
        return (int) lotto.getLotto().stream().filter(numberInput::contains).count();
    }

    public boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.getLotto().contains(Integer.parseInt(bonusInput));
    }

    private void validateWinNumbers() {
        HashSet<Integer> duplicate = new HashSet<>(numberInput);

        if (duplicate.size() != LOTTO_LIMIT) {
            throw new IllegalArgumentException(WIN_BALL_INVALID);
        }

        if (numberInput.size() > LOTTO_LIMIT) {
            throw new IllegalArgumentException(WIN_BALL_INVALID);
        }

        numberInput.forEach(number -> {
            if (number < START_NUMBER || number > LAST_NUMBER) {
                throw new IllegalArgumentException(WIN_BALL_INVALID);
            }
        });
    }

    private void validateBonusNumber() {
        int bonusNumber = Integer.parseInt(bonusInput);

        if (bonusNumber < START_NUMBER || bonusNumber > LAST_NUMBER) {
            throw new IllegalArgumentException(BONUS_BALL_INVALID);
        }

        if (numberInput.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_BALL_INVALID);
        }
    }
}
