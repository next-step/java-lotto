package lotto.view;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String receiveMoney() {
        System.out.println("로또 금액을 입력해주세요. 천원 단위로 입력 해야합니다.");
        return new Scanner(System.in).nextLine();
    }
}
