package edu.nextstep.camp.lotto.view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = scanner.nextInt();
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        return budget;
    }

    public static Collection<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();

        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
