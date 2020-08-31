package cc.oakk.lotto.view.impl;

import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.printer.Printer;
import cc.oakk.lotto.view.printer.StandardPrinter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputConsoleView implements InputView {
    private static final String NUMBER_DELIMITER = ", ";
    private final Scanner scanner;
    private final Printer<String> stringPrinter;

    public InputConsoleView() {
        this.scanner = new Scanner(System.in);
        this.stringPrinter = StandardPrinter.getInstance();
    }

    public InputConsoleView(Scanner scanner, Printer<String> stringPrinter) {
        this.scanner = scanner;
        this.stringPrinter = stringPrinter;
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

    @Override
    public void printMoneyInputHeader() {
        stringPrinter.print("구입금액을 입력해 주세요.");
    }

    @Override
    public void printWinningNumberInputHeader() {
        stringPrinter.print("\n지난 주 당첨 번호를 입력해 주세요.");
    }
}
