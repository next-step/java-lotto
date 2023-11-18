package step2.view;

import step2.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final int LOTTO_PRICE_PER_PIECE = 1000;
    private static final String DELIMITER = ", ";

    public static int inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int totalCount(final int purchaseAmount) {
        checkValidationPurchaseAmount(purchaseAmount);
        int totalCount = purchaseAmount / LOTTO_PRICE_PER_PIECE;
        System.out.println(totalCount + "개를 구매했습니다.");
        return totalCount;
    }

    public static LottoNumber winningLottoNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        return getWinningNumberSet(winningNumbers);
    }

    private static LottoNumber getWinningNumberSet(String winningNumber) {
        checkValidationWinningNumber(winningNumber);
        Set<Integer> winningLottoNumber = Arrays.stream(winningNumber.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return new LottoNumber(winningLottoNumber);
    }

    private static void checkValidationWinningNumber(String winningNumber) {
        if (Objects.isNull(winningNumber) || winningNumber.isBlank()) {
            throw new IllegalArgumentException("당첨 번호 입력이 필요합니다.");
        }
    }

    private static void checkValidationPurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE_PER_PIECE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
