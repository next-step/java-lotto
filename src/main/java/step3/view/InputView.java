package step3.view;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final int LOTTO_PRICE_PER_PIECE = 1000;
    private static final String DELIMITER = ", ";

    public static int purchaseAmount() {
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

    public static Set<Integer> winningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        checkValidationWinningNumbers(winningNumbers);
        return getWinningLottoNumbers(winningNumbers);
    }

    private static Set<Integer> getWinningLottoNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static int bonusNumber(Set<Integer> winningLottoNumbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        checkDuplicatedWinningNumbers(bonusNumber, winningLottoNumbers);
        return bonusNumber;
    }

    private static void checkDuplicatedWinningNumbers(int bonusNumber, Set<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복일 수 없습니다.");
        }
    }

    private static void checkValidationWinningNumbers(String winningNumbers) {
        if (Objects.isNull(winningNumbers) || winningNumbers.isBlank()) {
            throw new IllegalArgumentException("당첨 번호 입력이 필요합니다.");
        }
    }

    private static void checkValidationPurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE_PER_PIECE != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
