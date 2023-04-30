package step2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOWEST_PURCHASE_PRICE = 1000;
    private static final String DELIMITER = "[, ]";
    private static final int LOTTO_SIZE = 6;

    public static int getInputOfPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = scanner.nextInt();

        validatePurchasePrice(purchasePrice);

        int purchaseAmount = getPurchaseAmount(purchasePrice);
        System.out.printf("%d개를 구입했습니다.%n", purchaseAmount);

        return purchaseAmount;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOWEST_PURCHASE_PRICE) {
            throw new IllegalArgumentException(
                    String.format("최소 구입 금액은 %d원입니다.", LOWEST_PURCHASE_PRICE));
        }
    }

    private static int getPurchaseAmount(int purchasePrice) {
        return purchasePrice / LOWEST_PURCHASE_PRICE;
    }

    public static String getInputOfWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }
}
