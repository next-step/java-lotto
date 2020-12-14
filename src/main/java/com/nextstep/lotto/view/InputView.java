package com.nextstep.lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(SCANNER.nextLine());
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseToList(SCANNER.nextLine());
    }

    private static List<Integer> parseToList(String winningNumberString) {
        String[] numbers = winningNumberString.split(DELIMITER);
        return Stream.of(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = parseInt(SCANNER.nextLine());
        System.out.println();
        return bonusNumber;
    }

    private static int parseInt(String line) {
        return Integer.parseInt(line);
    }
}
