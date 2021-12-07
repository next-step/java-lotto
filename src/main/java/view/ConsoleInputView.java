package view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showPurchaseAmountInputMessage() {
        System.out.println("Enter Purchase Amount of Lotto");
    }

    @Override
    public void showManualPurchaseAmountInputMessage() {
        System.out.println("Enter The Amount of Manual Number");
    }

    @Override
    public void showManualLottoInputMessage() {
        System.out.println("Enter Manual Lotto Numbers");
    }

    @Override
    public void showWinningNumberInputMessage() {
        System.out.println("Enter Winning Number of Lotto");
    }

    @Override
    public void showBonusBallInputMessage() {
        System.out.println("Enter Number of Bonus Ball");
    }

    @Override
    public int purchaseAmount() {
        try {
            String rawInput = scanner.nextLine();
            return Integer.parseInt(rawInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("Purchase amount must be integer");
        }
    }

    @Override
    public String winningNumber() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Winning number must be string");
        }
    }

    @Override
    public int bonusBall() {
        try {
            int bonusBall = scanner.nextInt();
            scanner.nextLine();

            return bonusBall;
        } catch (Exception e) {
            throw new IllegalArgumentException("Bonus ball must be integer");
        }
    }
}
