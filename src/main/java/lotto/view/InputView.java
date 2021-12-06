package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INSERT_ANSWER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INSERT_BONUS = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static String questionPrice() {
        System.out.println(INSERT_PRICE);
        return getInputValue();
    }

    public static String questionAnswer() {
        System.out.println(INSERT_ANSWER);
        return getInputValue();
    }

    public static String questionBonus() {
        System.out.println(INSERT_BONUS);
        return getInputValue();
    }

    private static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
