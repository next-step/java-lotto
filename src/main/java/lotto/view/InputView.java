package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int ZERO = 0;
    public static final int LOTTO_PRICE = 1000;
    private Scanner scanner = new Scanner(System.in);

    public int money() {

        System.out.println("구매금액을 입력해 주세요.");
        int inputMoney = inputMoney();

        while (!normal(inputMoney)) {
            System.out.println("금액을 천원 단위로 입력 하세요.");
            inputMoney = inputMoney();
        }

        return inputMoney;
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

    private boolean normal(int money) {
        if (money <= ZERO) {
            return false;
        }
        return money % LOTTO_PRICE == ZERO;
    }
}
