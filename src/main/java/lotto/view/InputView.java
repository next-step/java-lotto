package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.NumberOfUserGenerateLotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputUserAmount() {
        System.out.println(Message.INPUT_USER_AMOUNT);

        return SCANNER.nextInt();
    }

    public static String inputPreviousWeekWinningNumber() {
        System.out.println(Message.INPUT_PREVIOUS_WEEK_WINNING_NUMBER);

        return SCANNER.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println(Message.INPUT_BONUS_BALL);

        return SCANNER.nextLine();
    }

    public static int inputNumberOfUserGenerateLotto() {
        System.out.println(Message.INPUT_NUMBER_OF_USER_GENERATE_LOTTO);

        return SCANNER.nextInt();
    }

    public static List<LottoNumbers> inputLottoOfUser(NumberOfUserGenerateLotto numberOfUserGenerateLotto) {
        System.out.println(Message.INPUT_LOTTOS_OF_USER);
        SCANNER.nextLine();

        return IntStream.range(0, numberOfUserGenerateLotto.getNumberOfUserGenerateLotto())
                .mapToObj(it -> new LottoNumbers(SCANNER.nextLine()))
                .collect(Collectors.toList());
    }

    private enum Message {
        INPUT_USER_AMOUNT("구입금액을 입력해 주세요."),
        INPUT_PREVIOUS_WEEK_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
        INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),
        INPUT_NUMBER_OF_USER_GENERATE_LOTTO("수동으로 구매할 로또 수를 입력해 주세요."),
        INPUT_LOTTOS_OF_USER("수동으로 구매할 번호를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
