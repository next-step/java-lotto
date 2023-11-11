package lotto.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int STANDARD = 1000;

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return isMorThanStandard(isNumber());

    }
    private static int isMorThanStandard(int number) {
        if (number% STANDARD != 0) {
            throw new InputMismatchException("1000원대만 결재가능합니다");
        }
        return number/STANDARD;
    }

    private static int isNumber() {
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException error) {
            throw new InputMismatchException("정수를 입력해 주세요");
        }
    }
}
