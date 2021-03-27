package step2.view;

import step2.domain.Lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        if (price % Lotto.PRICE != 0) {
            throw new RuntimeException(String.format("%s원 단위로 구입할 수 있습니다.", Lotto.PRICE));
        }
        return price;
    }
}
