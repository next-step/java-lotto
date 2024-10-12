package lotto.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String WINNING_NUMBER_DELIMITER = ", ";

    @Override
    public long getPurchaseAmountFromUser() {
        String userInput = SCANNER.nextLine();
        return Long.parseLong(userInput);
    }

    @Override
    public List<String> getWinningNumbersFromUser() {
        String[] splitted = SCANNER.nextLine().split(WINNING_NUMBER_DELIMITER);
        List<String> winningNumbers = getTrimmedStringNumbers(splitted);

        validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private List<String> getTrimmedStringNumbers(String[] splitted) {
        return Arrays.stream(splitted)
                .map(String::trim)
                .collect(Collectors.toList());
    }


    private void validateWinningNumbers(List<String> winningNumbers) {
        if (new HashSet<>(winningNumbers).size() != winningNumbers.size()) {
            throw new IllegalArgumentException("6개의 중복되지 않는 숫자를 입력하세요.");
        }
    }

}
