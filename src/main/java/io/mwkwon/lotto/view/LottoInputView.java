package io.mwkwon.lotto.view;
import io.mwkwon.lotto.interfaces.InputView;

import java.util.Scanner;

public class LottoInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String requestInputPayment(String message) {
        return this.requestInput(message);
    }

    @Override
    public String requestWinningLottoNumbers(String message) {
        return this.requestInput(message);
    }

    private String requestInput(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }
}
