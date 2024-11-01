package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DELIMITER = ",";

    private final Set<Integer> winningNumbers;

    public WinningLotto(String winningNumbers) {

        this.winningNumbers = parseWinningNumbers(winningNumbers);
    }

    private Set<Integer> parseWinningNumbers(String input) {
        String[] numbers = input.split(DELIMITER);

        Set<Integer> winningNumbers = new HashSet<>();

        for (String number : numbers) {
            int lottoNumber = Integer.parseInt(number.trim());

            validateNumber(lottoNumber);

            winningNumbers.add(lottoNumber);
        }

        validateWinningNumbersCount(winningNumbers);

        return winningNumbers;
    }

    private static void validateNumber(int lottoNumber) {
        if (LOTTO_MIN_NUMBER > lottoNumber || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 정수여야 합니다.");
        }
    }

    private void validateWinningNumbersCount(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 " + LOTTO_SIZE + "개의 숫자여야 합니다.");
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        return  (int) lotto.getLottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
