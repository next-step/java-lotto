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
    public void showWinningNumberInputMessage() {
        System.out.println("Enter Winning Number of Lotto");
    }

    @Override
    public int extractPurchaseAmount() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("Purchase amount must be integer");
        }
    }

    @Override
    public String extractWinningNumber() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Winning number must be string");
        }
    }
}
