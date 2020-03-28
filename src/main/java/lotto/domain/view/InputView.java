package lotto.domain.view;

import java.util.Scanner;

public class InputView {
    public static String inputBuyAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
