package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTOS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNER_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String INPUT_PURCHASE_AMOUNT_EXCEPTION = "구입금액은 숫자만 입력할 수 있습니다.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_EXCEPTION = "수동으로 구매할 로또 갯수는 숫자로 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_EXCEPTION = "수동 로또 번호는 숫자만 입력할 수 있습니다.";
    private static final String INPUT_MANUAL_LOTTO_PATTERN_EXCEPTION = "수동 로또 번호의 구분자는 콤마로 입력해주세요";
    private static final String INPUT_MANUAL_LOTTO_COUNT_OUT_OF_RANGE_EXCEPTION = "수동 로또 구매 가능 개수는 총 구매 로또 수를 넘을 수 없습니다.";
    private static final String INPUT_WINNER_NUMBERS_EXCEPTION = "당첨 번호는 숫자만 입력할 수 있습니다.";
    private static final String INPUT_PATTERN_EXCEPTION = "당첨_번호의_구분자를_콤마로_입력해주세요";
    private static final String INPUT_BONUS_NUMBER_EXCEPTION = "보너스 숫자는 숫자로 입력해주세요.";

    private static final String INPUT_WINNER_LOTTO_PATTERN = ",";
    private static final String INPUT_MANUAL_LOTTO_PATTERN = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public long moneyToBuyLotto() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(INPUT_PURCHASE_AMOUNT_EXCEPTION);
            return moneyToBuyLotto();
        }
    }

    public long manualLottoCount(long numberOfAllLottos) {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        try {
            long manualLottoCount = Long.parseLong(scanner.nextLine());
            validateManualLottoCount(numberOfAllLottos, manualLottoCount);
            return manualLottoCount;
        } catch (NumberFormatException e) {
            System.out.println(INPUT_MANUAL_LOTTO_COUNT_EXCEPTION);
            return manualLottoCount(numberOfAllLottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return manualLottoCount(numberOfAllLottos);
        }
    }

    private void validateManualLottoCount(long numberOfAllLottos, long manualLottoCount) {
        if (outOfRange(numberOfAllLottos, manualLottoCount)) {
            throw new IllegalArgumentException(INPUT_MANUAL_LOTTO_COUNT_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(long numberOfAllLottos, long manualLottoCount) {
        return manualLottoCount > numberOfAllLottos;
    }

    public List<List<Integer>> manualLottos(long manualLottoCount) {
        System.out.println(INPUT_MANUAL_LOTTOS_MESSAGE);
        return createManualLottos(manualLottoCount);
    }

    private List<List<Integer>> createManualLottos(long manualLottoCount) {
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(createManualLotto());
        }
        return manualLottos;
    }

    private List<Integer> createManualLotto() {
        try {
            List<Integer> manualLotto = new ArrayList<>();
            String[] inputManualLotto = scanner.nextLine().split(INPUT_MANUAL_LOTTO_PATTERN);
            for (String lottoNumber : inputManualLotto) {
                manualLotto.add(Integer.parseInt(lottoNumber.trim()));
            }
            return manualLotto;
        } catch (NumberFormatException e) {
            System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_EXCEPTION);
            return createManualLotto();
        } catch (PatternSyntaxException e) {
            System.out.println(INPUT_MANUAL_LOTTO_PATTERN_EXCEPTION);
            return createManualLotto();
        }
    }

    public int bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(INPUT_BONUS_NUMBER_EXCEPTION);
            return bonusNumber();
        }
    }

    public List<Integer> winnerLottoNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        try {
            return Arrays.stream(scanner.nextLine().split(INPUT_WINNER_LOTTO_PATTERN))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(INPUT_WINNER_NUMBERS_EXCEPTION);
            return winnerLottoNumbers();
        } catch (PatternSyntaxException e) {
            System.out.println(INPUT_PATTERN_EXCEPTION);
            return winnerLottoNumbers();
        }
    }
}
