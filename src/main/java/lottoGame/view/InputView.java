package lottoGame.view;

import lottoGame.InputException;
import lottoGame.model.InputParameter;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static InputParameter print() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        validateInput(amount);
        return new InputParameter(amount);
    }

    private static void validateInput(int amount) {
        if (amount < 1000) {
            throw new InputException("최소 금액 이상을 입력해주세요");
        }
    }
}
