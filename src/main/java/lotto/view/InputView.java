package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INSERT_ANSWER = "지난 주 당첨 번호를 입력해 주세요.";

    public String questionPrice() {
        System.out.println(INSERT_PRICE);
        return getInputValue();
    }

    public String questionAnswer() {
        System.out.println(INSERT_ANSWER);
        return getInputValue();
    }

    private String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
