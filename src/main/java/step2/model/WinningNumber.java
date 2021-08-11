package step2.model;

import java.util.ArrayList;
import java.util.List;

import static step2.model.LottoValidator.isBlank;
import static step2.model.LottoValidator.isDigit;

public class WinningNumber {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private void isValidNumberCount(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        if (numbers.length < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해주셔야합니다.");
        }
    }

    public List<Integer> getWinningNumbers(String winningNumbers) {
        isBlank(winningNumbers);

        isValidNumberCount(winningNumbers);

        String[] numbers = winningNumbers.split(",");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }

        for (String number : numbers) {
            isDigit(number);
        }

        List<Integer> winningNumberList = new ArrayList<>();
        for (String number : numbers) {
            int winningNumber = Integer.parseInt(number);
            isDuplicate(winningNumberList, winningNumber);
            winningNumberList.add(winningNumber);
        }

        return winningNumberList;
    }

    private void isDuplicate(List<Integer> winningNumberList, int winningNumber) {
        if (winningNumberList.contains(winningNumber)) {
            throw new IllegalArgumentException("당첨번호가 중복되었습니다. 다시 입력해주세요");
        }
    }
}
