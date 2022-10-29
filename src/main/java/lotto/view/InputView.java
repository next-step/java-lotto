package lotto.view;

import lotto.domain.LottoCount;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String AMOUNT_QUESTION_MESSAGE = "구입금액을 입력해 주세요. (1장당 1000원 입니다.)";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = NEXT_LINE + "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTOS_MESSAGE = NEXT_LINE + "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_QUESTION_MESSAGE = NEXT_LINE + "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askAmount() {
        System.out.println(AMOUNT_QUESTION_MESSAGE);
        return inputAnswer();
    }

    public static String askManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
        return inputAnswer();
    }

    public static List<String> askInputManualLottos(LottoCount lottoCount) {
        System.out.println(MANUAL_LOTTOS_MESSAGE);
        return Stream.generate(InputView::inputAnswer)
                .limit(lottoCount.number()).collect(Collectors.toList());
    }

    public static String askWinningLottoNumbers() {
        System.out.println(WINNING_NUMBERS_QUESTION_MESSAGE);
        return inputAnswer();
    }

    public static String askBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return inputAnswer();
    }

    private static String inputAnswer() {
        return SCANNER.nextLine();
    }
}
