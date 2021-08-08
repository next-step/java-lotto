package lotto.presentation;

import java.util.Scanner;

public class PurchaseAmountInputView {

    private static final String INPUT_PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요.";

    public int input(){
        System.out.println(INPUT_PURCHASE_AMOUNT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
