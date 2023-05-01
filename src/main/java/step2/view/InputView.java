package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int LOWEST_PURCHASE_PRICE = 1000;
    private static final String DELIMITER = ", ";
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;

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

    public static void printLottos(String lottosToString) {
        System.out.println(lottosToString);
    }

    public static List<Integer> getInputOfWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine(); // 입력 버퍼 비워주기
        String[] inputSplit = scanner.nextLine().split(DELIMITER);

        validateWinningNumbers(inputSplit);
        return toIntegerList(inputSplit);
    }

    private static void validateWinningNumbers(String[] inputSplit) {
        if (inputSplit.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(
                    String.format("당첨 번호는 %d개여야 합니다. ', '로 구분하여 입력하여 주세요.", LOTTO_SIZE)
            );
        }
    }

    private static List<Integer> toIntegerList(String[] inputSplit) {
        List<Integer> intList = new ArrayList<>();
        for (String numberString : inputSplit) {
            int number = Integer.parseInt(numberString);
            validateEachNumber(number);
            intList.add(number);
        }
        return intList;
    }

    private static void validateEachNumber(int number) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 당첨 번호는 1 ~ 45 사이의 수입니다.");
        }
    }
}
