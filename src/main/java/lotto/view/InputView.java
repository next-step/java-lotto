package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ONLY_NUMBER_EXCEPTION = "숫자만 입력 가능합니다";

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return SCANNER.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_EXCEPTION, e);
        }
    }


}
