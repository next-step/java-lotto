package lotto.view;

import lotto.service.LottoNumber;
import lotto.service.LottoNumbers;
import lotto.service.WinningNumbers;
import lotto.dto.LottoRequest;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.service.LottoPaper.LOTTO_PRICE;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_RESULT_MESSAGE = "개를 구매했습니다.";

    private static final String INPUT_MANUAL_PURCHASE_LOTTO_COUNT_MESSAGE =
            "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_PURCHASE_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 " +
            "주세요.";

    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public LottoRequest inputLottoRequest() {
        int amount = inputAmount();

        int manualCount = inputManualCount();

        Set<LottoNumbers> lottoNumbersSet = inputManualLottoSet(manualCount);

        int autoCount = inputAutoCount(amount, manualCount);

        return new LottoRequest(autoCount, lottoNumbersSet);
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        String input = scanner.nextLine();
        String[] numbers = input.split(WINNING_NUMBERS_DELIMITER);

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        int bonusNumber = scanner.nextInt();

        return new WinningNumbers(convertStringToLottoNumbers(numbers),
                new LottoNumber(bonusNumber));
    }

    private int inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    private int inputManualCount() {
        System.out.println(INPUT_MANUAL_PURCHASE_LOTTO_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    private Set<LottoNumbers> inputManualLottoSet(int manualCount) {
        Set<LottoNumbers> lottoNumbersSet = new HashSet<>();
        System.out.println(INPUT_MANUAL_PURCHASE_LOTTO_NUMBERS_MESSAGE);
        for (int i = 0; i < manualCount; i++) {
            String input = scanner.nextLine();
            String[] numbers = input.split(WINNING_NUMBERS_DELIMITER);

            lottoNumbersSet.add(convertStringToLottoNumbers(numbers));
        }
        return lottoNumbersSet;
    }

    private int inputAutoCount(int amount, int manualCount) {
        int autoCount = (amount / LOTTO_PRICE) - manualCount;
        System.out.println(autoCount + PURCHASE_RESULT_MESSAGE);
        return autoCount;
    }

    private LottoNumbers convertStringToLottoNumbers(String[] numbers) {
        return new LottoNumbers(Arrays.stream(numbers)
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
