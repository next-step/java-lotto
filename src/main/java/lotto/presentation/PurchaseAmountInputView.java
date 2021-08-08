package lotto.presentation;

import java.util.Scanner;

public class PurchaseAmountInputView {

    private static final String PURCHASE_AMOUNT_INPUT_COMMENT = "구입금액을 입력해 주세요.";

    public int input(){
        System.out.println(PURCHASE_AMOUNT_INPUT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
