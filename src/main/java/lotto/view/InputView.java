package lotto.view;

import java.util.Scanner;

public class InputView {
    public static long purchaseAmount() {
        System.out.println("구매금액을 입력해주세요.");
        Scanner in = new Scanner(System.in);
        return in.nextLong();
    }

    public static String inputLastWinningLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
