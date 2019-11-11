package step2.view;

import step2.domain.Bonus;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        return sc.nextInt();
    }

    public static String getLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return sc.next();
    }

    public static Bonus getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return new Bonus(sc.nextInt());
    }
}
