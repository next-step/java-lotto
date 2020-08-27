package lotto.view;

import java.util.Scanner;

public class InputView {
    public static int getLottoPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int lottoPrice = Integer.parseInt(scanner.nextLine());

        return lottoPrice;
    }
}
