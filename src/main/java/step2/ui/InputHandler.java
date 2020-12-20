package step2.ui;

import step2.*;

import java.util.ArrayList;
import java.util.List;
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

    public Amount getManualAmount() {
        try {
            OutputHandler.print("수동으로 구매할 로또 수를 입력해 주세요");
            int value = Integer.parseInt(scanner.nextLine());
            return Amount.of(value);
        } catch (NumberFormatException | NullPointerException e) {
            return getManualAmount();
        }
    }

    public LottoPurchaseRequest getPurchaseRequest(Money money, Amount amount) {
        try {
            OutputHandler.print("수동으로 구매할 번호를 입력해 주세요.");
            List<LottoNumbers> numbers = new ArrayList<>();
            for (int i = 0; i < amount.getValue(); i++) {
                numbers.add(new InputNumbers(scanner.nextLine()).getNumbers());
            }
            return new LottoPurchaseRequest(money, numbers);
        } catch (NullPointerException | IllegalArgumentException e) {
            return getPurchaseRequest(money, amount);
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

    public InputNumbers getPreviousWeekWinNumbers() {
        try {
            OutputHandler.print("지난 주 당첨 번호를 입력해 주세요");
            return new InputNumbers(scanner.nextLine());
        } catch (NumberFormatException | NullPointerException e) {
            return getPreviousWeekWinNumbers();
        }
    }
}
