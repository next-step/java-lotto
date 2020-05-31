package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class InputView {

    private static final int PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력하세요";

    private static final String PURCHASE_MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PURCHASE_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력하세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int inputLottoAmount() {
        System.out.println(PURCHASE_PRICE_MESSAGE);

        int price = SCANNER.nextInt();
        int amount = price / PRICE_UNIT;

        System.out.println();
        return amount;
    }

    public static int inputManualLottoAmount() {
        System.out.println(PURCHASE_MANUAL_AMOUNT_MESSAGE);
        int amount = SCANNER.nextInt();
        System.out.println();
        return amount;
    }

    public static Set<LottoNumber> inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);

        String winningNumbers = SCANNER.next();

        return Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_BALL_MESSAGE);
        int bonusNumber = SCANNER.nextInt();
        System.out.println();
        return bonusNumber;
    }

    public static List<LottoNumbers> inputManualLottoNumbers(int amount) {
        System.out.println(PURCHASE_MANUAL_NUMBER_MESSAGE);

        List<LottoNumbers> lottoNumbers = IntStream.range(0, amount)
            .mapToObj(value -> convertToIntArray(SCANNER.next()))
            .map(LottoNumbers::of)
            .collect(Collectors.toList());

        System.out.println();
        return lottoNumbers;
    }

    private static int[] convertToIntArray(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
