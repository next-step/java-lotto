package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.NumberOfUserGenerateLotto;
import lotto.domain.UserAmount;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_USER_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBER_OF_USER_GENERATE_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTOS_OF_USER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_PREVIOUS_WEEK_WINNING_NUMBER_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static UserAmount inputUserAmount() {
        System.out.println(INPUT_USER_AMOUNT_MESSAGE);

        try {
            int userAmount = Integer.parseInt(SCANNER.nextLine());
            return new UserAmount(userAmount);
        } catch (NumberFormatException e) {
            printExceptionMessage(e);
        }

        return inputUserAmount();
    }

    public static NumberOfUserGenerateLotto inputNumberOfUserGenerateLotto(UserAmount userAmount) {
        System.out.println(INPUT_NUMBER_OF_USER_GENERATE_LOTTO_MESSAGE);

        try {
            int numberOfUserGenerateLotto = Integer.parseInt(SCANNER.nextLine());
            return new NumberOfUserGenerateLotto(numberOfUserGenerateLotto, userAmount);
        } catch (NumberFormatException e) {
            printExceptionMessage(e);
        }

        return inputNumberOfUserGenerateLotto(userAmount);
    }

    public static List<LottoNumbers> inputLottoOfUser(NumberOfUserGenerateLotto numberOfUserGenerateLotto) {
        System.out.println(INPUT_LOTTOS_OF_USER_MESSAGE);

        try {
            return IntStream.range(0, numberOfUserGenerateLotto.getNumberOfUserGenerateLotto())
                    .mapToObj(it -> new LottoNumbers(SCANNER.nextLine()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            printExceptionMessage(e);
        }

        return inputLottoOfUser(numberOfUserGenerateLotto);
    }

    public static LottoNumbers inputPreviousWeekWinningNumber() {
        System.out.println(INPUT_PREVIOUS_WEEK_WINNING_NUMBER_MESSAGE);

        try {
            String lottoNumbers = SCANNER.nextLine();
            return new LottoNumbers(lottoNumbers);
        } catch (Exception e) {
            printExceptionMessage(e);
        }

        return inputPreviousWeekWinningNumber();
    }

    public static LottoNumber inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);

        try {
            String s = SCANNER.nextLine();
            return new LottoNumber(s);
        } catch (Exception e) {
            printExceptionMessage(e);
        }

        return inputBonusBall();
    }

    private static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
