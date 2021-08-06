package lotto.step2.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MESSAGE = "구입금액을 입력해주세요";
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println(INPUT_MESSAGE);

        return sc.nextInt();
    }
}
