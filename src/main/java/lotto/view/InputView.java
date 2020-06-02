package lotto.view;

import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class InputView {

    private static final int PRICE_UNIT = 1000;

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력하세요";

    private static final String PURCHASE_MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PURCHASE_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력하세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }


    public static LottoRequestDto inputAmountAndLottoNumber() {
        int amount = inputLottoAmount();
        int manualLottoAmount = inputManualLottoAmount();
        int autoLottoAmount = amount - manualLottoAmount;

        List<String> manualLottoNumbers = inputManualLottoNumbers(manualLottoAmount);

        return new LottoRequestDto(autoLottoAmount, manualLottoNumbers);
    }

    public static WinningLottoDto inputWinningLottoNumber(){
        String winningNumber = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        return new WinningLottoDto(winningNumber, bonusNumber);
    }

    private static int inputLottoAmount() {
        System.out.println(PURCHASE_PRICE_MESSAGE);

        int price = SCANNER.nextInt();
        int amount = price / PRICE_UNIT;

        System.out.println();
        return amount;
    }

    private static int inputManualLottoAmount() {
        System.out.println(PURCHASE_MANUAL_AMOUNT_MESSAGE);
        int amount = SCANNER.nextInt();
        System.out.println();
        return amount;
    }

    private static List<String> inputManualLottoNumbers(int amount) {
        System.out.println(PURCHASE_MANUAL_NUMBER_MESSAGE);

        List<String> lottoNumbers = IntStream.range(0, amount)
                .mapToObj(value -> SCANNER.next())
                .collect(Collectors.toList());

        System.out.println();
        return lottoNumbers;
    }

    private static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return SCANNER.next();
    }

    private static int inputBonusNumber() {
        System.out.println(BONUS_BALL_MESSAGE);
        int bonusNumber = SCANNER.nextInt();
        System.out.println();
        return bonusNumber;
    }
}
