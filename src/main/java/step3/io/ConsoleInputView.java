package step3.io;

import java.util.Scanner;

import step3.util.StringUtils;

public class ConsoleInputView {

    private static final String NEED_PRICE = "구입금액을 입력해 주세요.";
    private static final String NEED_VICTORY_NUMBER_TEXT = "지난 주 당첨 번호를 입력해 주세요.(,구분자로 사용)";
    private static final String NEED_BONUS = "보너스 볼을 입력해 주세요.";
    private Scanner scanner;

    public ConsoleInputView() {
        scanner = new Scanner(System.in);
    }

    public Integer getPrice() {
        System.out.println(NEED_PRICE);
        return StringUtils.parseInt(scanner.nextLine());
    }

    public String getVictoryNumbers() {
        System.out.println(NEED_VICTORY_NUMBER_TEXT);
        return scanner.nextLine();
    }

    public String getBonusNumber() {
        System.out.println(NEED_BONUS);
        return scanner.nextLine();
    }

}
