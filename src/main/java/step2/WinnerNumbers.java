package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerNumbers {

    private final List<Integer> winNumbers = new ArrayList<>();

    public WinnerNumbers(String numbers) {
        validNull(numbers);
        splitNumbers(numbers);
        validNumberCount();
    }

    private void validNull(String nums) {
        if (nums == null) {
            throw new IllegalArgumentException("당첨 번호는 null이면 안됩니다.");
        }
    }

    private void splitNumbers(String numbers) {
        String[] splitArray = numbers.split(", ");
        for (String num : splitArray) {
            insertWinNumbers(num);
        }
    }

    private void insertWinNumbers(String number) {
        isNumeric(number);
        winNumbers.add(Integer.parseInt(number));
    }

    private void isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void validNumberCount() {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 형식과 맞는 숫자 개수를 입력하세요.");
        }
    }

    public List<Integer> getWinNumbers() {
        return Collections.unmodifiableList(winNumbers);
    }
}
