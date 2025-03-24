package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        String[] split = input.split(",");
        List<Integer> arr = new ArrayList<>();
        for (String s : split) {
            arr.add(Integer.parseInt(s.trim()));
        }
        validateWinningNumbers(arr);
        this.numbers = arr;
    }

    private void validateWinningNumbers(List<Integer> arr) {
        if (arr.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(arr).size() != arr.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
        for (Integer num : arr) {
            validateWinningNumberRange(num);
        }
    }

    private void validateWinningNumberRange(Integer num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    public int countNumberMatching(Lotto lotto) {
        return lotto.confirmWinning(this.numbers);
    }
}
