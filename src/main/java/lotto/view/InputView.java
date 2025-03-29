package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Number;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Amount purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        scanner.nextLine();
        return new Amount(price);
    }

    public static Lotto winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.from(scanner.nextLine());
    }

    public static Number BonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanner.nextInt();
        scanner.nextLine();
        return new Number(number);
    }
}
