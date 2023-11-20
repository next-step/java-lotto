package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer start() {
        System.out.println("구입 금액을 입력해주세요");
        int money = scanner.nextInt();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매는 1000원 단위로 구매할 수 있습니다.");
        }
        return money / 1000;
    }
}
