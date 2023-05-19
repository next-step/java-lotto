package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOWEST_PURCHASE_PRICE = 1000;
    private static final String DELIMITER = ", ";

    public static int getInputOfPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = scanner.nextInt();

        validatePurchasePrice(purchasePrice);
        return purchasePrice;
    }

    private static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOWEST_PURCHASE_PRICE) {
            throw new IllegalArgumentException(
                    String.format("최소 구입 금액은 %d원입니다.", LOWEST_PURCHASE_PRICE));
        }
    }

    public static int printPurchaseAmount(int purchasePrice) {
        int purchaseAmount = getPurchaseAmount(purchasePrice);
        System.out.printf("%d개를 구매했습니다.%n", purchaseAmount);
        return purchaseAmount;
    }

    private static int getPurchaseAmount(int purchasePrice) {
        return purchasePrice / LOWEST_PURCHASE_PRICE;
    }

    public static List<Integer> getInputOfWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine(); // 입력 버퍼 비워주기
        String[] inputSplit = scanner.nextLine().split(DELIMITER);
        return toIntegerList(inputSplit);
    }

    private static List<Integer> toIntegerList(String[] inputSplit) {
        List<Integer> intList = new ArrayList<>();
        for (String numberString : inputSplit) {
            int number = Integer.parseInt(numberString);
            intList.add(number);
        }
        return intList;
    }

    public static int getInputOfBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
