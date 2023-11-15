package step1.view;

import step1.model.scanner.InputLottoScanner;
import step1.model.scanner.LottoScanner;

import java.util.Scanner;

public class OperatorInputView {

    public static final String PUT_FORMULA = "연산식을 입력해주세요.";

    public String inputString() {
        LottoScanner scannerInput = new InputLottoScanner();
        Scanner scanner = scannerInput.get();
        System.out.println(PUT_FORMULA);
        return scanner.nextLine();
    }
}
