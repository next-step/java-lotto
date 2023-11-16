package lotto.view;

import java.util.Scanner;

public class IoView {
    private static final Scanner sc = new Scanner(System.in);

    private int inputPint() {
        int money = 0;

        System.out.println("구입금액을 입력해 주세요");
        money = sc.nextInt();
        System.out.println(Math.floorDiv(money, 1000) + "개를 구매했습니다.");
        return money;
    }


}
