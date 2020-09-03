package cc.oakk.lotto.view.impl;

import cc.oakk.lotto.util.StringUtils;
import cc.oakk.lotto.view.InputView;
import cc.oakk.lotto.view.printer.Printer;
import cc.oakk.lotto.view.printer.StandardPrinter;

import java.util.Arrays;
import java.util.InputMismatchException;
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
        if (money <= 0) {
            throw new InputMismatchException("0원 보다 큰 돈을 입력해주세요.");
        }
        scanner.nextLine();
        return money;
    }

    @Override
    public int readManualLottoCount() {
        int money = scanner.nextInt();
        if (money <= 0) {
            throw new InputMismatchException("0보다 큰 수를 입력해주세요.");
        }
        scanner.nextLine();
        return money;
    }

    @Override
    public List<Integer> readNumbers() {
        String input = scanner.nextLine();

        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(StringUtils::parseInt)
                .collect(Collectors.toList());
    }

    @Override
    public int readBonusNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    @Override
    public void printMoneyInputHeader() {
        stringPrinter.print("구입금액을 입력해 주세요.");
    }

    @Override
    public void printManualLottoCountInputHeader() {
        stringPrinter.print("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    @Override
    public void printManualLottoNumbersInputHeader() {
        stringPrinter.print("수동으로 구매할 번호를 입력해 주세요.");
    }

    @Override
    public void printWinningNumberInputHeader() {
        stringPrinter.print("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    @Override
    public void printBonusNumberInputHeader() {
        stringPrinter.print("보너스 볼을 입력해 주세요.");
    }

    @Override
    public void printError(Throwable throwable) {
        stringPrinter.print("오류발생: " + throwable.getMessage());
    }
}
