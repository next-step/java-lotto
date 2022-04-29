package lotto.ui;

import lotto.domain.Lotto;
import lotto.exception.InvalidLottoLengthException;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.InvalidPriceException;
import lotto.util.Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PREVIOUS_WEEK_LOTTO_MESSAGE = "지난 주 당첨번호를 입력해주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String COUNT_OF_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";
    private static final String INVALID_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요.";

    private InputView() {
    }

    public static int inputPrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        int price = SCANNER.nextInt();
        try {
            validatePrice(price);
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
            return inputPrice();
        }
        SCANNER.nextLine(); // Delete newLine
        return price;
    }

    public static void validatePrice(int price) {
        if (price < 0) {
            throw new InvalidPriceException(price);
        }
    }

    public static Lotto inputLottoOfPreviousWeek() {
        try {
            System.out.println(PREVIOUS_WEEK_LOTTO_MESSAGE);
            Integer[] lottoNumber = Utility.convertStringArrayToIntegerArray(Utility.split(SCANNER.nextLine()));
            return new Lotto(lottoNumber);
        } catch (InvalidLottoLengthException e) {
            System.out.println(e.getMessage());
            return inputLottoOfPreviousWeek();
        } catch (InvalidLottoNumberException e) {
            System.out.println(e.getMessage());
            return inputLottoOfPreviousWeek();
        }
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int inputCountOfManualLotto() {
        try {
            System.out.println(COUNT_OF_MANUAL_LOTTO_MESSAGE);
            int countOfManualLotto = SCANNER.nextInt();
            SCANNER.nextLine(); // Delete newLine
            return countOfManualLotto;
        } catch (InputMismatchException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(INVALID_INPUT_NUMBER_MESSAGE);
            return inputCountOfManualLotto();
        }
    }
}
