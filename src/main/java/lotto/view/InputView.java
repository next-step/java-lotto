package lotto.view;

import lotto.model.Lotto;
import lotto.model.Winning;
import lotto.model.dto.LottoNumber;
import lotto.util.SplitUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Result.LOTTO_PRICE;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String RETRY_INPUT_MESSAGE = "다시 입력해주세요.";
    public static final String INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final int START_NUMBER = 0;
    public static final String ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT = "수동으로 구매하고자 하는 로또의 갯수가 구입금액보다 큽니다.";
    public static final String ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER = "수동으로 구매하고자 하는 로또의 갯수는 음수가 될 수 없습니다";
    public static final String ERROR_LOWER_MINIMUM_BUY_AMOUNT = "최소 구매금액보다 작습니다.";
    public static final String LOTTO_NOT_ALLOWED_REMAINDER = "로또는 천원단위로 구매가 가능합니다.";

    public static int inputBuyAmount() {
        try {
            System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
            int buyAmount = scannerNextInt();// TODO: 객체 추출

            boolean lowerMinimumBuyAmount = buyAmount < LOTTO_PRICE;
            if (lowerMinimumBuyAmount) {
                throw new IllegalArgumentException(ERROR_LOWER_MINIMUM_BUY_AMOUNT);
            }

            boolean isNotBuyAmountRemainderZero = buyAmount % LOTTO_PRICE != 0;
            if (isNotBuyAmountRemainderZero) {
                throw new IllegalArgumentException(LOTTO_NOT_ALLOWED_REMAINDER);
            }

            return buyAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputBuyAmount();
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

    public static int inputManualBuyCount(int buyCount) {
        try {
            System.out.println(INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE);
            int manualBuyCount = scannerNextInt();

            boolean isManualCountBiggerThanBuyCount = buyCount < manualBuyCount;
            if (isManualCountBiggerThanBuyCount) {
                throw new IllegalArgumentException(ERROR_MANUAL_COUNT_BIGGER_THAN_BUY_COUNT);
            }

            boolean isMinus = manualBuyCount < 0;
            if (isMinus) {
                throw new IllegalArgumentException(ERROR_MANUAL_COUNT_NOT_ALLOWED_NEGATIVE_NUMBER);
            }

            return manualBuyCount;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputManualBuyCount(buyCount);
        }
    }

    public static List<Lotto> inputManualLottoes(final int manualBuyCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE);
        try {
            return IntStream.range(START_NUMBER, manualBuyCount)
                    .mapToObj(i -> {
                        int[] numbers = SplitUtil.stringToNumbers(SCANNER.nextLine());
                        return new Lotto(numbers);
                    }).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + RETRY_INPUT_MESSAGE);
            return inputManualLottoes(manualBuyCount);
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
            int[] parsedLottoNumbers = SplitUtil.stringToNumbers(SCANNER.nextLine());
            List<LottoNumber> lottoNumbers = Arrays.stream(parsedLottoNumbers)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());
            return new Lotto(() -> lottoNumbers);
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
