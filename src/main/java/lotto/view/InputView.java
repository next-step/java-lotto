package lotto.view;

import lotto.controller.dto.LottoPurchaseRequest;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public LottoPurchaseRequest inputPurchaseInfo() {
        return new LottoPurchaseRequest(inputPurchaseAmount());
    }

    private int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
