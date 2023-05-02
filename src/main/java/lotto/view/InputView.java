package lotto.view;

import lotto.util.Util;

import java.util.Scanner;

public class InputView {

    private static final String ERROR_INPUT = "잘못된 값을 입력했습니다.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputPurchaseAmount() {
        String purchaseAmount = scanner.nextLine();
        validateInput(purchaseAmount);
        return purchaseAmount;
    }

    public String inputFirstLottoNumber() {
        String lottoNumber =  scanner.nextLine();
        validateInput(lottoNumber);
        return lottoNumber;
    }

    private void validateInput(String input) {
        if(Util.isNullOrEmpty(input)) {
            throw new IllegalArgumentException(ERROR_INPUT);
        }
    }
}
