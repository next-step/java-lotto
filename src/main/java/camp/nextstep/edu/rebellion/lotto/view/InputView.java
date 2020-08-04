package camp.nextstep.edu.rebellion.lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int getPurchaseAmount() {
        System.out.print("구입 금액을 입력해 주세요 (로또 1장의 가격은 1000원 입니다) ");
        if (SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다");
    }
}
