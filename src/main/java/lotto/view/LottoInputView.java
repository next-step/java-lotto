package lotto.view;

import lotto.dto.PurchaseMoney;

import java.util.Scanner;

public class LottoInputView {
    private static final String QUESTION_PURCHASE_MONEY = "구입금액을 입력해 주세요.";

    private Scanner scanner;

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public PurchaseMoney questionPurchaseMoney() {
        System.out.println(QUESTION_PURCHASE_MONEY);
        String playerInput = scanner.nextLine();

        return new PurchaseMoney(playerInput);
    }
}
