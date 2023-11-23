package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";

    public static final String INPUT_PURCHASE_AMOUNT_EXCEPTION = "구입금액은 숫자만 입력할 수 있습니다.";
    public static final String INPUT_WINNER_NUMBERS_EXCEPTION = "당첨 번호는 숫자만 입력할 수 있습니다.";
    public static final String INPUT_PATTERN_EXCEPTION = "당첨_번호의_구분자를_콤마로_입력해주세요";

    public static final String INPUT_WINNER_LOTTO_PATTERN = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public long moneyToBuyLotto() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_PURCHASE_AMOUNT_EXCEPTION);
        }
    }

    public List<Integer> winnerLottoNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        try {
            return Arrays.stream(scanner.nextLine().split(INPUT_WINNER_LOTTO_PATTERN))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_WINNER_NUMBERS_EXCEPTION);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException(INPUT_PATTERN_EXCEPTION);
        }
    }
}
