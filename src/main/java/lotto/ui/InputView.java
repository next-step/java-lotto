package lotto.ui;

import lotto.model.WinningInfo;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public int receiveInputMoney() {
        System.out.println("How much will you pay?");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public WinningInfo receiveInputWinningInfo() {
        System.out.println("Input winning numbers of last week");
        String strWinningNumbers = scanner.nextLine();

        System.out.println("Input bonus ball number");
        int bonusNumber = scanner.nextInt();
        return new WinningInfo(strWinningNumbers, bonusNumber);
    }
}
