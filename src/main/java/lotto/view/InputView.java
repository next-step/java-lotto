package lotto.view;

import java.util.Scanner;

public class InputView {

    public static String inputBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return input();
    }

    private static String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }
}
