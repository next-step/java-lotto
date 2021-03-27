package step2.view;

import step2.constants.Constants;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (price % Constants.LOTTO_PRICE != 0) {
            throw new RuntimeException(String.format("%s원 단위로 구입할 수 있습니다.", Constants.LOTTO_PRICE));
        }
        return price;
    }
}
