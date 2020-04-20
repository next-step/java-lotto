package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.exception.InvalidLottoNumbersException;
import lotto.exception.InvalidManualLottoCountException;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String WINNING_DELIMITER = ", ";

    private static final String MONEY_INPUT_NOTICE = "구입금액을 입력해 주세요.";
    private static final String MONEY_INVALID_NOTICE = "1000원 이상의 금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_NOTICE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_INVALID_NOTICE = "잘못 된 수동으로 구매할 로또의 갯수입니다. 0 이상의 숫자 값을 입력해 주세요!";
    private static final String MANUAL_LOTTO_NUMBERS_NOTICE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_NOTICE = "보너스 볼을 입력해 주세요.";
    private static final String BONUS_NUMBER_INVALID_RANGE_NOTICE = "보너스 볼의 값이 정상적인 범위를 벗어났습니다.";
    private static final String BONUS_NUMBER_INVALID_CONTAINED_NOTICE = "보너스 볼의 값이 이미 당첨번호에 포함되어 있습니다.";

    private static final String MANUAL_LOTTO_COUNT_EXCEPTION_MESSAGE = "구매 할 로또의 갯수는 양의 정수 값입니!";
    private static final String BONUS_NUMBER_EXCEPTION_MESSAGE = "보너스 볼의 값은 양의 정수 값입니다!";

    private static final int MONEY_DEFAULT = 0;
    private static final int MONEY_MINIMUM = 1000;
    private static final int DEFAULT_NUMBER = -1;
    private static final int MANUAL_LOTTO_COUNT_MINIMUM = 0;

    public static int getMoney() {
        int money;
        do {
            System.out.println(MONEY_INPUT_NOTICE);
            money = parseMoney();
        } while (!isValidMoney(money));

        return money;
    }

    private static int parseMoney() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return MONEY_DEFAULT;
        }
    }

    private static boolean isValidMoney(int money) {
        if (money < MONEY_MINIMUM) {
            System.out.println(MONEY_INVALID_NOTICE);
            return false;
        }

        return true;
    }

    public static int getManualLottoCount() {
        int count;
        do {
            System.out.println(MANUAL_LOTTO_COUNT_NOTICE);
            count = parseManualLottoCount();
        } while (!isValidCount(count));

        return count;
    }

    private static int parseManualLottoCount() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidManualLottoCountException(MANUAL_LOTTO_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isValidCount(int count) {
        if (count < MANUAL_LOTTO_COUNT_MINIMUM) {
            System.out.println(MANUAL_LOTTO_COUNT_INVALID_NOTICE);
            return false;
        }

        return true;
    }

    public static Lottos getLottos(int manualLottoCount) {
        if (manualLottoCount == MANUAL_LOTTO_COUNT_MINIMUM) {
            return new Lottos();
        }

        System.out.println(MANUAL_LOTTO_NUMBERS_NOTICE);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottos.add(generateManualLotto());
        }

        return Lottos.getInstance(lottos);
    }

    private static Lotto generateManualLotto() {
        return Lotto.of(Arrays.stream(getLottoNumbers())
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    private static String[] getLottoNumbers() {
        return scanner.nextLine().split(WINNING_DELIMITER);
    }

    public static WinningNumbers getWinnerNumbers() {
        System.out.println(WINNING_NUMBERS_NOTICE);

        return getWinningNumbers(getLottoNumbers());
    }

    private static WinningNumbers getWinningNumbers(String[] inputs) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return WinningNumbers.getInstance(winningNumbers, getBonusNumber(winningNumbers));
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;

        do {
            bonusNumber = parseBonusNumber();
        } while (!isValidBonusNumber(bonusNumber, winningNumbers));

        return bonusNumber;
    }

    private static int parseBonusNumber() {
        System.out.println(BONUS_NUMBER_NOTICE);

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumbersException(BONUS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (!LottoNumber.isValidNumber(bonusNumber)) {
            System.out.println(BONUS_NUMBER_INVALID_RANGE_NOTICE);
            return false;
        }

        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(BONUS_NUMBER_INVALID_CONTAINED_NOTICE);
            return false;
        }

        return true;
    }
}
