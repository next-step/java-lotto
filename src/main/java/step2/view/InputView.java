package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int LOTTERY_PRICE_PER_PIECE = 1000;
    private static final String DELIMITER = ", ";

    public static int inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getTotalCount(final int purchaseAmount) {
        checkValidationPurchaseAmount(purchaseAmount);
        int totalCount = purchaseAmount / LOTTERY_PRICE_PER_PIECE;
        System.out.println(totalCount + "개를 구매했습니다.");
        return totalCount;
    }

    public static List<Integer> getWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        return getWinningNumberList(winningNumbers);
    }

    private static List<Integer> getWinningNumberList(String winningNumber) {
        return Arrays.stream(checkValidationWinningNumbers(winningNumber))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] checkValidationWinningNumbers(String winningNumber) {
        if (Objects.isNull(winningNumber) || winningNumber.isBlank()) {
            throw new IllegalArgumentException("당첨 번호 입력이 필요합니다.");
        }

        String[] winningNumbers = winningNumber.trim().split(DELIMITER);
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호 ', ' 기준으로 입력해야하며 6개의 숫자만 입력 가능합니다.");
        }

        return winningNumbers;
    }

    private static void checkValidationPurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % LOTTERY_PRICE_PER_PIECE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
