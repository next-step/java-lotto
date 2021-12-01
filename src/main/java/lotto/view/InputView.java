package lotto.view;

import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.WinningNumbers;
import lotto.model.LottoRequest;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.LottoPaper.LOTTO_PRICE;

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
        System.out.println(INPUT_AMOUNT_MESSAGE);
        int amount = Integer.parseInt(scanner.nextLine());

        System.out.println(INPUT_MANUAL_PURCHASE_LOTTO_COUNT_MESSAGE);
        int manualCount = Integer.parseInt(scanner.nextLine());

        Set<LottoNumbers> lottoNumbersSet = new HashSet<>();
        System.out.println(INPUT_MANUAL_PURCHASE_LOTTO_NUMBERS_MESSAGE);
        for (int i = 0; i < manualCount; i++) {
            String input = scanner.nextLine();
            String[] numbers = input.split(WINNING_NUMBERS_DELIMITER);

            lottoNumbersSet.add(convertStringToLottoNumbers(numbers));
        }

        int autoCount = (amount / LOTTO_PRICE) - manualCount;
        System.out.println(autoCount + PURCHASE_RESULT_MESSAGE);

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

    private LottoNumbers convertStringToLottoNumbers(String[] str) {
        return new LottoNumbers(Arrays.stream(str)
                .map(Integer::valueOf)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }
}
