package lotto.view;

import lotto.domain.Lotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] getInputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return parse(scanner.nextLine());
    }

    private static String[] parse(String s) {
        String[] strs = s.split(",");

        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
        }

        return strs;
    }
}
