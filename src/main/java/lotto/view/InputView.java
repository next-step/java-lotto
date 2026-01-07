package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static BigDecimal inputPurchaseAmount() {
        return inputWithRetry("구입금액을 입력해 주세요.", "올바른 금액을 입력해 주세요.",
                () -> new BigDecimal(scanner.nextLine()));
    }

    public static Lotto inputWinningNumbers() {
        System.out.println();
        return inputWithRetry("지난 주 당첨 번호를 입력해 주세요.", "올바른 당첨 번호를 입력해 주세요.",
                () -> parseLotto(scanner.nextLine()));
    }

    public static LottoNumber inputBonusNumber() {
        return inputWithRetry("보너스 볼을 입력해 주세요.", "올바른 보너스 번호를 입력해 주세요.",
                () -> LottoNumber.valueOf(scanner.nextInt()));
    }

    public static int inputManualCount() {
        return inputWithRetry("수동으로 구매할 로또 수를 입력해 주세요.", "올바른 숫자를 입력해 주세요.",
                () -> Integer.parseInt(scanner.nextLine()));
    }

    public static List<String> inputManualLotto(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoTexts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String lottoText = scanner.nextLine();
            lottoTexts.add(lottoText);
        }
        return lottoTexts;
    }

    private static Lotto parseLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    private static <T> T inputWithRetry(String message, String errorMessage, Supplier<T> input) {
        while (true) {
            try {
                if (!message.isEmpty()) {
                    System.out.println(message);
                }
                return input.get();
            } catch (Exception e) {
                System.out.println(errorMessage);
                scanner.nextLine();  // 버퍼 비우기
            }
        }
    }
}
