package cc.oakk.lotto.view.impl;

import cc.oakk.lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputConsoleView implements InputView {
    private static final String NUMBER_DELIMITER = ", ";
    private final Scanner scanner;

    public InputConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public InputConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readMoney() {
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    @Override
    public List<Integer> readWinningNumbers() {
        String input = scanner.nextLine();

        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
