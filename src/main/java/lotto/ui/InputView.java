package lotto.ui;

import lotto.domain.*;
import lotto.exception.*;
import lotto.util.Utility;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        try {
            System.out.println(PURCHASE_PRICE_MESSAGE);
            int price = SCANNER.nextInt();
            validateNegativeNumber("구입금액", price);
            validateMinPriceToBuyLotto(price);
            SCANNER.nextLine(); // Delete newLine
            return price;
        } catch (InvalidNegativeNumberException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputPrice();
        } catch (InvalidPriceToBuyLottoExcpetion e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputPrice();
        } catch (InputMismatchException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(INVALID_INPUT_NUMBER_MESSAGE);
            return inputPrice();
        }
    }

    static void validateNegativeNumber(String target, int value) {
        if (value < 0) {
            throw new InvalidNegativeNumberException(target, value);
        }
    }

    static void validateMinPriceToBuyLotto(int price) {
        if (price < Lottos.LOTTO_PRICE_PER_ONE) {
            throw new InvalidPriceToBuyLottoExcpetion(price);
        }
    }

    public static LottoWinningCondition inputWinningConditionOfLotto() {
        try {
            Lotto previousLotto = inputLottoOfPreviousWeek();
            LottoNumber bonusNumber = inputBonusNumber();
            return new LottoWinningCondition(previousLotto, bonusNumber);
        } catch (InvalidBonusNumberException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputWinningConditionOfLotto();
        }
    }

    private static Lotto inputLottoOfPreviousWeek() {
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

    private static LottoNumber inputBonusNumber() {
        try {
            System.out.println(BONUS_NUMBER_MESSAGE);
            return LottoNumber.valueOf(SCANNER.nextInt());
        } catch (InvalidLottoNumberException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public static int inputCountOfManualLotto(int price) {
        try {
            System.out.println(COUNT_OF_MANUAL_LOTTO_MESSAGE);
            int countOfManualLotto = SCANNER.nextInt();
            validateNegativeNumber("수동입력 로또 개수", countOfManualLotto);
            validateCountOfManualLotto(price, countOfManualLotto);
            SCANNER.nextLine(); // Delete newLine
            return countOfManualLotto;
        } catch (InvalidNegativeNumberException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputCountOfManualLotto(price);
        } catch (InvalidCountOfManualLotto e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(e.getMessage());
            return inputCountOfManualLotto(price);
        } catch (InputMismatchException e) {
            SCANNER.nextLine(); // Delete newLine
            System.out.println(INVALID_INPUT_NUMBER_MESSAGE);
            return inputCountOfManualLotto(price);
        }
    }

    static void validateCountOfManualLotto(int price, int countOfManualLotto) {
        int countOfTotalLotto = price / Lottos.LOTTO_PRICE_PER_ONE;
        if (countOfTotalLotto < countOfManualLotto) {
            throw new InvalidCountOfManualLotto(countOfTotalLotto, countOfManualLotto);
        }
    }

    public static List<Lotto> inputManualLottos(int countOfManualLotto) {
        final List<Lotto> manualLottos = new ArrayList<>(countOfManualLotto);
        while (countOfManualLotto > 0) {
            inputManualLotto(manualLottos);
            countOfManualLotto--;
        }

        return manualLottos;
    }

    private static void inputManualLotto(List<Lotto> manualLottos) {
        System.out.println(MANUAL_LOTTO_MESSAGE);

        try {
            Integer[] lottoNumber = Utility.convertStringArrayToIntegerArray(Utility.split(SCANNER.nextLine()));
            manualLottos.add(new Lotto(lottoNumber));
        } catch (NumberFormatException e) {
            System.out.print(e.getMessage().replaceFirst(".*For input string: ", INVALID_INPUT_NUMBER_MESSAGE + "(현재 입력: "));
            System.out.println(")");
            inputManualLotto(manualLottos);
        } catch (InvalidLottoLengthException e) {
            System.out.println(e.getMessage());
            inputManualLotto(manualLottos);
        } catch (InvalidLottoNumberException e) {
            System.out.println(e.getMessage());
            inputManualLotto(manualLottos);
        }
    }
}
