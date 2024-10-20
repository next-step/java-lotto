package lotto.view;

import lotto.model.BuyAmount;
import lotto.model.Lotto;
import lotto.model.ManualCount;
import lotto.model.Winning;
import lotto.model.dto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.util.SplitUtil.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String RETRY_INPUT_MESSAGE = "다시 입력해주세요.";
    public static final String INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static BuyAmount inputBuyAmount() {
        try {
            System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
            return new BuyAmount(scannerNextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputBuyAmount();
        }
    }

    public static ManualCount inputManualCount(BuyAmount buyAmount) {
        try {
            System.out.println(INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE);
            return new ManualCount(scannerNextInt(), buyAmount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputManualCount(buyAmount);
        }
    }

    public static LottoNumber inputBonusLottoNumber() {
        try {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
            return new LottoNumber(scannerNextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputBonusLottoNumber();
        }
    }

    public static List<Lotto> inputManualLottoes(final ManualCount manualCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
        try {
            return manualCount.createLotto(i -> new Lotto(stringToNumbers(SCANNER.nextLine())));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputManualLottoes(manualCount);
        }
    }

    public static Winning inputWinning(Lotto winningLotto) {
        try {
            LottoNumber bonusNumber = InputView.inputBonusLottoNumber();
            return new Winning(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinning(winningLotto);
        }
    }

    public static Lotto inputWinningLotto() {
        try {
            System.out.println();
            System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
            int[] parsedLottoNumbers = stringToNumbers(SCANNER.nextLine());
            return new Lotto(() -> Arrays.stream(parsedLottoNumbers)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningLotto();
        }
    }

    private static int scannerNextInt() {
        int result = SCANNER.nextInt();
        SCANNER.nextLine();// NOTE: nextInt 후에 Enter 키를 누르면 그 개행 문자가 입력 버퍼에 남아 있으므로 남아 있는 개행 문자 소비
        return result;
    }
}
