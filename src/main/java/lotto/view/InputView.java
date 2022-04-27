package lotto.view;

import lotto.exception.InvalidInputWinningNumberException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String DELIMITER = ",";
    private static final String INVALID_READ_MONEY_ERROR_MESSAGE = "구매 금액을 제대로 입력해주세요.";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Scanner scanner = new Scanner(System.in);

    public BigDecimal readMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return BigDecimal.valueOf(parseLong(readInput()));
    }

    private long parseLong(String input) {
        long longValue;
        try {
            longValue = Long.parseLong(input);
        } catch (RuntimeException e) {
            throw new NumberFormatException(INVALID_READ_MONEY_ERROR_MESSAGE);
        }
        return longValue;
    }

    public List<Integer> readWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = readInput().replaceAll(" ", "");
        return getWinningNumbers(input);
    }

    private String readInput() {
        return scanner.nextLine();
    }

    private List<Integer> getWinningNumbers(String input) {
        String[] split = splitInputByDelimiter(input);
        List<Integer> winningNumbers = convertNumbers(split);
        validWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private void validWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidInputWinningNumberException();
        }
    }

    private List<Integer> convertNumbers(String[] split) {
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] splitInputByDelimiter(String input) {
        return input.split(DELIMITER);
    }
}
