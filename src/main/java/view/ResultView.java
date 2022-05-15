package view;

import domain.LottoNumbers;
import domain.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String WINNER_INPUT_ANNOUNCEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public ResultView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Winner scanWinnerNumbersWithAnnouncement() {
        System.out.println(WINNER_INPUT_ANNOUNCEMENT);
        return scanWinnerNumbers();
    }

    private Winner scanWinnerNumbers() {
        String input = scanner.nextLine();
        List<Integer> inputNumbers = parseNumbers(input);
        try {
            return new Winner(LottoNumbers.create(inputNumbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanWinnerNumbers();
        }
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
