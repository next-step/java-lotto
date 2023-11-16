package validator;

import util.LottoNumberSplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberValidator {

    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;

    public static List<Integer> checkWinningNumberInput(String[] winningNum) {
        validateLottoNumberCount(winningNum);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNum) {
            try {
                winningNumbers.add(Integer.parseInt(number.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format: " + number, e);
            }
        }

        return winningNumbers;
    }

    private static void validateLottoNumberCount(String[] winningNumbers) {
        if (winningNumbers.length < LOTTO_NUMBER_COUNT_LIMIT) {
            throw new IllegalArgumentException("로또 숫자는 6개 입력이 필요합니다.");
        }
    }
}
