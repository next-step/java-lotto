package step2.ui;

import step2.LottoNumber;
import step2.Money;

import java.util.Scanner;

public class InputHandler {

    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public Money getPurchasingMoney() {
        try {
            OutputHandler.print("구입 금액을 입력해 주세요");
            int value = Integer.parseInt(scanner.nextLine());
            return Money.of(value);
        } catch (NumberFormatException | NullPointerException e) {
            return getPurchasingMoney();
        }
    }

    public LottoNumber getBonusNumber() {
        try {
            OutputHandler.print("보너스 볼을 입력해 주세요");
            int value = Integer.parseInt(scanner.nextLine());
            return LottoNumber.of(value);
        } catch (NumberFormatException | NullPointerException e) {
            return getBonusNumber();
        }
    }

    public WinNumbers getPreviousWeekWinNumbers() {
        try {
            OutputHandler.print("지난 주 당첨 번호를 입력해 주세요");
            return new WinNumbers(scanner.nextLine());
        } catch (NumberFormatException | NullPointerException e) {
            return getPreviousWeekWinNumbers();
        }
    }
}
