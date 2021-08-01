package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String HOW_MUCH = "구입금액을 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static int askHowMuch() {
        System.out.println(HOW_MUCH);
        String text = scanner.nextLine();
        return Integer.parseInt(text);
    }

    public static String askForWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
