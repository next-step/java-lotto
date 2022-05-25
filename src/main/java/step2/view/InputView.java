package step2.view;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int getPurchase() {

        System.out.println("구입금액을 입력해 주세요.");

        int price = sc.nextInt();

        if(price % 1000 != 0)throw new IllegalArgumentException("1000원 단위로 구매가능합니다.");

        return price;
    }

    public static String getWinningNum() {
        return sc.nextLine();
    }
}
