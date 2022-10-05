package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LIST_INPUT_DELIMITER = ",";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String MANUALLY_BUYING_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUALLY_BUYING_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";

    public static Money scanPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Money.of(Integer.parseInt(scanner.nextLine()));
    }

    public static List<Integer> scanWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Arrays.stream(scanner.nextLine().split(LIST_INPUT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer scanBonusNumber() {
        System.out.println(BONUS_NUMBER_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    public static Integer scanManualLottoCount() {
        System.out.println(MANUALLY_BUYING_LOTTO_COUNT_QUESTION);
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    public static Lottos scanManualLottos(Integer lottoCount) {
        if (lottoCount > 0) {
            System.out.println(MANUALLY_BUYING_LOTTO_NUMBERS_QUESTION);
        }

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> numbers = Arrays.stream(scanner.nextLine().split(LIST_INPUT_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }

        return new Lottos(lottos);
    }
}
