package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int priceView() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 1장의 가격은 1000원입니다.");
        }
        int number = money / 1000;
        System.out.println(number + "개를 구매했습니다.");
        return number;
    }
}
