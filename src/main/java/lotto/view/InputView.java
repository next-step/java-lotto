package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String BUY_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LUCKY_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner sc = new Scanner(System.in);

    private InputView(){

    }

    public static int inputBuyMoney(){
        System.out.println(BUY_MONEY_INPUT_MESSAGE);
        return sc.nextInt();
    }

    public static String inputLuckyNumber(){
        System.out.println(LUCKY_NUMBER_MESSAGE);
        sc.nextLine();
        return sc.nextLine();
    }

}
