package automaticlotto.view;

import automaticlotto.automaticexception.InputValueException;

import java.util.Scanner;

import static automaticlotto.automaticexception.ExceptionCommand.PRICE_EXCEPTION_MESSAGE;

public class InputView {

    private static final int LOTTO_PRICE_MIN = 1;
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {

    }

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(sc.nextLine());
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE_MIN) {
            throw new InputValueException(PRICE_EXCEPTION_MESSAGE);
        }
    }

}
