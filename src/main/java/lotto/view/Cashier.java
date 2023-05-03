package lotto.view;

import java.util.Scanner;

public class Cashier {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static void sayLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
