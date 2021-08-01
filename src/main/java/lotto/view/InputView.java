package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String getPurchaseAmountQuestion = "구입금액을 입력해 주세요.";

    private InputView(){

    }
    public static int getPurchaseAmount(){
        System.out.println(getPurchaseAmountQuestion);
        return scanner.nextInt();
    }
}
