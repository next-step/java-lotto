package step2.view;

import step2.domain.LottoConstant;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private int money;
    private String inputWinningNumber;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println(LottoConstant.INPUT_MONEY_MESSAGE);
        money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public String inputWinningNumber() {
        System.out.println(LottoConstant.INPUT_WINNING_NUMBER_MESSAGE);
        inputWinningNumber = scanner.nextLine();
        return inputWinningNumber;
    }
}
