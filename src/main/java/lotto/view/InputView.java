package lotto.view;

import lotto.controller.dto.PurchaseLottoAutoRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public PurchaseLottoAutoRequest inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseLottoAutoRequest(scanner.nextInt());
    }
}
