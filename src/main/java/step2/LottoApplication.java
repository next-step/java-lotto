package step2;

import java.util.Scanner;

public class LottoApplication {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        final int inputValue = scanner.nextInt();

        final int numberOfPurchases = getNumberOfPurchases(inputValue);
        System.out.printf("%d개를 구매했습니다.\n", numberOfPurchases);
    }

    public static int getNumberOfPurchases(int inputValue) {
        return inputValue / LOTTO_PRICE;
    }
}
