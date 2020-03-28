package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final int PRICE_PER_PIECE = 1000;
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scanner.nextInt();
        System.out.println(String.format("%d개를 구매 했습니다.", price / PRICE_PER_PIECE));
        return price;
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
