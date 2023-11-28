package lotto.view;

import java.util.*;

import static lotto.util.NumberUtil.floorDiv;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요");
        int money = sc.nextInt();
        invalidInputMoney(money);
        System.out.println(floorDiv(money) + "개를 구매했습니다.");
        return money;
    }

    public static int inputPassiveNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static String inputPassiveNumbers() {
        sc.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        return sc.nextLine();
    }


    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨번호를 입력 해주세요");
        return sc.nextLine();
    }


    private static void invalidInputMoney(int money) {
        if(money < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액만 가능합니다.");
        }
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
