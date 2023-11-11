package lotto.step2.input;

import java.util.Scanner;

public class InputView {
    public static UserInput input() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        final int purchaseAmount = scanner.nextInt();

        return new UserInput(purchaseAmount);
    }
}
