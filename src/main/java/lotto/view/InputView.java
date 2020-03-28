package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MONEY_TEXT = "구입급액을 입력해 주세요.";
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static int inputMoney() {
        System.out.println(INPUT_MONEY_TEXT);
        return scanner.nextInt();
    }
}
