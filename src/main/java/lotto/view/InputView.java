package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String FORMAT_ERROR_MESSAGE = ERROR_MESSAGE + "숫자를 입력해 주세요.";
    public static final String LOTTO_QUANTITY_ERROR = ERROR_MESSAGE + "구매할 로또의 수는 음수가 될 수 없습니다.";
    private static final Scanner scanner = new Scanner(System.in);
    public static final int MIN_LOTTO_COUNT = 0;

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return inputNumberToInt();
    }

    private int inputNumberToInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(FORMAT_ERROR_MESSAGE);
        }
    }

    public List<String> inputManualLotto() {
        int count = inputManualLottoCount();
        if (count > MIN_LOTTO_COUNT) {
            System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
        }
        return IntStream.range(MIN_LOTTO_COUNT, count)
                .mapToObj(lotto -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    private int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
        int count = inputNumberToInt();
        validateLottoCount(count);
        return count;
    }

    private static void validateLottoCount(int count) {
        if (count < MIN_LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_QUANTITY_ERROR);
        }
    }

    public LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return LottoNumber.of(inputNumberToInt());
    }

    public Lotto inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Lotto.createFromString(scanner.nextLine());
    }
}
