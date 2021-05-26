package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int money() {
        System.out.println("구매금액을 입력해 주세요.");
        return inputMoney();
    }

    private int inputMoney() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("구매금액은 정수만 입력 가능합니다. 구매 금액을 다시 입력해 주세요.");
            scanner = new Scanner(System.in);
            return inputMoney();
        }
    }

    public String numbers() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
