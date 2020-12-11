package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Long inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextLong();
    }
    public static String inputWinningLotto() {
        sc.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
