package study.step2.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    private InputView(){}

    public static String inputMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputLastWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)");
        return scanner.nextLine();
    }
}
