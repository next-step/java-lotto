package step2.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> winningNumbers;

    private static final int LOTTO_NUMBER_COUNT = 6;

    public WinningNumber(String numbers) {
        isBlank(numbers);
        isValidNumberCount(numbers);

        winningNumbers = new ArrayList<>();
        for (String number : numbers.split(",")) {
            LottoNumber winningNumber = new LottoNumber(number);
            isDuplicate(winningNumbers, winningNumber);
            winningNumbers.add(winningNumber);
        }
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> results = new ArrayList<>();

        for (LottoNumber number : winningNumbers) {
            results.add(number.getLottoNumber());
        }

        return results;
    }

    private void isBlank(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isValidNumberCount(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        if (numbers.length < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해주셔야합니다.");
        }
    }

    private void isDuplicate(List<LottoNumber> winningNumbers, LottoNumber winningNumber) {
        if (winningNumbers.contains(winningNumber)) {
            throw new IllegalArgumentException("당첨번호가 중복되었습니다. 다시 입력해주세요");
        }
    }

}
