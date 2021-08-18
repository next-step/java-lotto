package lotto.presentation.input;

import java.util.Scanner;

public class PurchaseAmountInputView {

    private static final String PURCHASE_AMOUNT_INPUT_COMMENT = "구입금액을 입력해 주세요.";
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    public int input(){
        System.out.println(PURCHASE_AMOUNT_INPUT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = scanner.nextInt();
        validate(purchaseAmount);
        return purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if(purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("로또 최소 구매 금액은 1000원 이상이어야 합니다.");
        }
    }

}
