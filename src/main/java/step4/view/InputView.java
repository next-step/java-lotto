package step4.view;

import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.UserLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final int LOTTO_PRICE_PER_PIECE = 1000;
    private static final String DELIMITER = ", ";

    public static int purchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        checkValidationPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public static int manualLottoCount(final int purchaseAmount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = scanner.nextInt();
        checkValidationManualLottoCount(purchaseAmount, manualLottoCount);
        return manualLottoCount;
    }

    public static List<UserLotto> manualLottoNumbers(final int manualLottoCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> scanner.nextLine())
                .map(manualLottoNumbers -> new UserLotto(getLottoNumbers(manualLottoNumbers)))
                .collect(Collectors.toList());
    }

    public static int automaticLottoCount(final int purchaseAmount, final int manualLottoCount) {
        int automaticLottoCount = (purchaseAmount / LOTTO_PRICE_PER_PIECE) - manualLottoCount;
        System.out.println("수동으로 " + manualLottoCount + "장, " + "자동으로 " + automaticLottoCount + "장을 구매했습니다.");
        return automaticLottoCount;
    }

    public static Set<LottoNumber> winningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();
        return getLottoNumbers(winningNumbers);
    }

    public static int bonusNumber(final Set<LottoNumber> winningLottoNumbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }

    private static Set<LottoNumber> getLottoNumbers(final String inputNumbers) {
        checkValidationInputNumbers(inputNumbers);
        return Arrays.stream(inputNumbers.trim().split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private static void checkValidationManualLottoCount(final int purchaseAmount, final int manualLottoCount) {
        if (manualLottoCount * 1000 > purchaseAmount) {
            throw new IllegalArgumentException("구입 금액보다 더 많은 개수를 구매할 수 없습니다.");
        }
    }

    private static void checkValidationInputNumbers(final String winningNumbers) {
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
