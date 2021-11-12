package lotto.step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputOrderPrice() {
        System.out.println("구매 금액을 입력해주세요");
        return sc.nextInt();
    }

}
