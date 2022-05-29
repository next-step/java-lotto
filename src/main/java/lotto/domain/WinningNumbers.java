package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final int LOTTERY_AMOUNT = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private List<Integer> winningNumberList;

    public WinningNumbers(String number) {
        this(new ArrayList<>(), number);
    }

    public WinningNumbers(List<Integer> winningNumberList, String number) {
        this.winningNumberList = winningNumberList;
        convertToList(number);
    }

    private void convertToList(String number) {
        Arrays.stream(splitNumbers(number)).forEach(stringNumber -> winningNumberList.add(Integer.parseInt(stringNumber)));
    }

    private String[] splitNumbers(String number) {
        String[] numberArray = number.split(",");

        if (numberArray.length != LOTTERY_AMOUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 숫자로 이루어져 있습니다.");
        }

        for (String numberString : numberArray) {
            validateNumberRange(numberString);
        }

        return numberArray;
    }

    private void validateNumberRange(String numberString) {
        int integer = Integer.parseInt(numberString);
        if (integer < START_NUMBER || integer > END_NUMBER) {
            throw new IllegalArgumentException("당첨 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }
}
