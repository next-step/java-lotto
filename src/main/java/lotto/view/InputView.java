package lotto.view;

import lotto.data.Lotto;
import lotto.data.LottoCount;
import lotto.data.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.data.Lotto.validateBonusNumber;
import static lotto.data.Lotto.validateInputLottoNumber;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_MANUAL_LOTTO_COUNTS = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ",";

    private InputView() {
        //
    }

    public static int getPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        int price = scanner.nextInt();
        System.out.println();
        return price;
    }

    public static LottoCount getManualLottoCounts() {
        System.out.println(QUESTION_MANUAL_LOTTO_COUNTS);
        int manualLottoCountInput = scanner.nextInt();
        System.out.println();
        return new LottoCount(manualLottoCountInput);
    }

    public static Lotto getWinningNumbers() {
        System.out.println(QUESTION_WINNING_NUMBERS);
        String winningNumberInput = scanner.next();
        List<String> stringNumbers = List.of(winningNumberInput.split(DELIMITER));

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : stringNumbers) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }

        validateInputLottoNumber(winningNumbers);

        return new Lotto(winningNumbers);
    }

    public static Lottos getManualLottoNumbers(LottoCount manualLottoCount) {
        System.out.println(QUESTION_MANUAL_LOTTO_NUMBERS);
        List<Lotto> manualLottos = new ArrayList<>();

        for (int count = 0; count < manualLottoCount.getCount(); count++) {
            String price = scanner.next();
            List<String> stringNumbers = List.of(price.split(DELIMITER));

            List<Integer> numbers = new ArrayList<>();
            for (String number : stringNumbers) {
                numbers.add(Integer.valueOf(number.trim()));
            }
            manualLottos.add(new Lotto(numbers));
        }

        return new Lottos(manualLottos);
    }

    public static int getBonusNumber(Lotto winningNumbers) {
        System.out.println(QUESTION_BONUS_NUMBERS);
        int bonusNumber = scanner.nextInt();
        System.out.println();

        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
