package lotto;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    public static String getLottoPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            return scanner.nextLine();
        }
        throw new IllegalStateException("입력값을 받지 못했습니다.");
    }

}
