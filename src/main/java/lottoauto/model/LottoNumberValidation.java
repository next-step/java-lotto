package lottoauto.model;

import java.util.HashSet;
import java.util.List;

public class LottoNumberValidation {

    private static final int LOTTO_LIMIT_SIZE = 6;

    public static void checkLotto(List<Integer> numbers) {
        boolean usableNumber = numbers.stream().allMatch(number -> number >= 1 && number <= 45);

        if (!usableNumber) {
            throw new IllegalArgumentException("로또 숫자는 1에서 45사이의 숫자여야 합니다.");
        }

        if (numbers.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("로또의 숫자가 6개가 아닙니다.");
        }

        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != LOTTO_LIMIT_SIZE) {
            throw new IllegalStateException("중복되는 숫자가 있습니다.");
        }
    }

    public static void checkWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        checkLotto(winningNumber);

        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 당첨 숫자에 포함되어 있습니다.");
        }

        if (!Lotto.LOTTO_NUMBER_RANGE.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 1~45까지의 숫자를 입력해야 합니다.");
        }
    }
}
