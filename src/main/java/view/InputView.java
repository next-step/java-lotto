package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private final String LOTTO_PRICE_TOTAL = "구입금액을 입력해주세요.";

    public int inputPrice() {
        System.out.println(LOTTO_PRICE_TOTAL);
        return Integer.parseInt(scanner.nextLine());
    }

}
