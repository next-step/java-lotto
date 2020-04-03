package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MSG_MONEY_INPUT = "구입금액을 입력해 주세요. 구입금액은 1000원 이상만 입력 가능합니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInputForMoney(){
        printQuestion(MSG_MONEY_INPUT);
        int money = scanner.nextInt();
        validateGreaterThan1000(isGreaterThan1000(money));
        return money;
    }

    private static boolean isGreaterThan1000(int money){
       return money >= 1000;
    }

    private static void validateGreaterThan1000(boolean isGreaterThan1000){
        if(!isGreaterThan1000){
            getInputForMoney();
        }
    }

    private static void printQuestion(String message){
        System.out.println(message);
    }
}
