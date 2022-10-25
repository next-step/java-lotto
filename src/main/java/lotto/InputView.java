package lotto;

import java.util.Scanner;

import static lotto.Profit.LOTTO_PRICE;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputQuantity() {
        System.out.println("구매금액을 입력해 주세요");
        return SCANNER.nextInt() / LOTTO_PRICE;
    }

    public static void printQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static String[] inputWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        SCANNER.nextLine();
        return SCANNER.nextLine().split(",");
    }
}
