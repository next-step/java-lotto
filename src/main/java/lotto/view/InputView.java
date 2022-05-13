package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.exception.NotSupportInstanceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTO_COUNT = "수동으로 로매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new NotSupportInstanceException();
    }

    public static int purchaseAmountView() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return inputInt();
    }

//    public static int purchaseAmountView() {
//        try {
//            System.out.println(MESSAGE_PURCHASE_AMOUNT);
//            return inputPurchaseAmount();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            return inputPurchaseAmount();
//        }
//    }
//
//    private static int inputPurchaseAmount() {
//        return inputInt();
//    }

    public static int bonusBallView() {
        System.out.println(MESSAGE_BONUS_BALL);
        return inputInt();
    }

    public static int manualLottoCountView() {
        System.out.println(MESSAGE_MANUAL_LOTTO_COUNT);
        return inputInt();
    }

    public static List<LottoNumbers> manualLottoNumberValuesView(int manualLottoCount) {
        System.out.println(MESSAGE_MANUAL_LOTTO_NUMBERS);
        List<LottoNumbers> manualLottoNumberValues = new ArrayList<>();
        while (manualLottoNumberValues.size() < manualLottoCount) {
            String value = scanner.nextLine();
            manualLottoNumberValues.add(new LottoNumbers(value));
        }
        return manualLottoNumberValues;
    }

    private static int inputInt() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static String lastWinningLottoNumberView() {
        System.out.println(MESSAGE_LAST_WINNING_LOTTO_NUMBER);
        return scanner.nextLine();
    }
}
