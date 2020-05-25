package lotto.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO_NUMBER = 0;

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        validateMoney(money);
        return money;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void validateMoney(int inputMoney) {
        if (inputMoney <= ZERO_NUMBER) {
            throw new IllegalArgumentException("0원 이하는 로또를 살 수 없습니다.");
        }

        if (inputMoney % LOTTO_PRICE != ZERO_NUMBER) {
            throw new IllegalArgumentException("이 구매기는 거스름돈이 없습니다. 1000원 단위로 입력하세요");
        }
    }
}
