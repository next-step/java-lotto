package step3.io;

import java.util.Scanner;

import step3.util.StringUtils;

public class ConsoleInputView {

    private static final String NEED_PRICE = "구입금액을 입력해 주세요.";
    private Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    public Integer getPrice() {
        System.out.println(NEED_PRICE);
        return StringUtils.parseInt(scanner.nextLine());
    }

    public String getVictoryNumbers() {
        return scanner.nextLine();
    }

}
