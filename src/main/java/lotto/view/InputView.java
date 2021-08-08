package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String GET_PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String GET_MANUAL_PURCHASE_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String GET_MANUAL_LOTTO_NUMBER_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String SPLIT_CUSTOM_REGEX = ",|, | ,";

    private InputView() {

    }

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_QUESTION);
        return scanner.nextInt();
    }

    public static int getManualLottoTicketCount() {
        System.out.println(GET_MANUAL_PURCHASE_QUESTION);
        return scanner.nextInt();
    }

    public static void manualLottoNumberQuestion() {
        scanner.nextLine();
        System.out.println(GET_MANUAL_LOTTO_NUMBER_QUESTION);
    }

    public static List<Integer> getManualLottoNumber() {
        String LottoNumbers = scanner.nextLine();
        String trimWinningNumberString = LottoNumbers.replace(SPACE, BLANK);
        return makeWinningNumber(trimWinningNumberString);
    }

    public static List<Integer> getWinningNumber() {
        scanner.nextLine();
        System.out.println(GET_WINNING_NUMBER_QUESTION);
        String LottoNumbers = scanner.nextLine();
        String trimWinningNumberString = LottoNumbers.replace(SPACE, BLANK);
        return makeWinningNumber(trimWinningNumberString);
    }

    private static List<Integer> makeWinningNumber(String trimWinningNumberString) {
        return Arrays.stream(trimWinningNumberString.split(SPLIT_CUSTOM_REGEX))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_QUESTION);
        return scanner.nextInt();
    }
}
