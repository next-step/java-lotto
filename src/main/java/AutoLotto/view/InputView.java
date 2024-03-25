package autoLotto.view;

import autoLotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private static final String VALID_NUMBER = "[0-9]\\d*";
    private static final String VALID_LOTTO_NUMBER = "^[0-9]{1,2}(,[0-9]{1,2})*$";
    private static final String COMMA_DELIMITER = ",";
    private static final int DIVISION_UNIT = 1000;

    private static final int VALID_LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 숫자로만 입력해 주세요.\n(ex : 1000)";
    private static final String MANUAL_PURCHASE_AMOUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 로또 번호를 입력해 주세요.";
    private static final String PURCHASE_DENIED = "1,000원 단위로 구매 가능합니다.\n구입금액을 다시 입력해주세요.";
    private static final String MANUAL_LOTTO_PURCHASE_DENIED = "총 로또 구매개수 이하, 0 이상의 숫자로만 수동 로또를 구매할 수 있습니다.\n수동 로또 구매 개수를 다시 입력해주세요.";
    private static final String WIN_NUMBERS_QUESTION = "당첨 번호 6개를 입력해주세요.\n(ex : 1,2,3,4,5,6)";
    private static final String LOTTO_NUMBERS_DENIED = "쉼표를 기준으로 1 ~ 45 사이의 숫자 6개의 숫자를 입력하셔야 합니다.\n당첨 번호를 다시 입력해주세요.\n(ex: 1,2,3,4,5,6)";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String BONUS_NUMBER_DENIED = "당첨 번호와 중복 없이 1 ~ 45 사이의 숫자 1개만 입력이 가능합니다.\n보너스 번호를 다시 입력해주세요.";

    public int inputPurchase() {
        return startPurchase(PURCHASE_AMOUNT_QUESTION);
    }

    private int startPurchase(String question) {
        outputQuestion(question);
        String input = scanner.nextLine();

        while (!isValidNumberInput(input) || !isValidPaymentUnit(input)) {
            outputQuestion(PURCHASE_DENIED);
            input = scanner.nextLine();
        }

        return divideUnit(input);
    }

    private void outputQuestion(String question) {
        System.out.println(question);
    }

    private boolean isValidNumberInput(String input) {
        return input.matches(VALID_NUMBER);
    }

    private boolean isValidPaymentUnit(String input) {
        Long inputLong = Long.parseLong(input);
        return inputLong / DIVISION_UNIT >= 1;
    }

    private int divideUnit(String input) {
        int inputAsInt = Integer.valueOf(input);
        return inputAsInt / DIVISION_UNIT;
    }

    public int inputManualPurchase(int purchaseAmount) {
        return startManualPurchase(purchaseAmount, MANUAL_PURCHASE_AMOUNT_QUESTION);
    }

    private int startManualPurchase(int numberOfTotalLottos, String question) {
        outputQuestion(question);
        String input = scanner.nextLine();

        while (!isValidNumberInput(input) || !isValidNumberOfManualLottos(numberOfTotalLottos, input)) {
            outputQuestion(MANUAL_LOTTO_PURCHASE_DENIED);
            input = scanner.nextLine();
        }

        return Integer.valueOf(input);
    }

    private boolean isValidNumberOfManualLottos(int numberOfTotalLottos, String input) {
        int numberOfManualLottos = Integer.valueOf(input);

        if (numberOfTotalLottos < numberOfManualLottos) {
            return false;
        }

        return true;
    }

    public List<Lotto> buyManualLottos(int numberOfManualLottos) {
        if (numberOfManualLottos == 0) {
            return new ArrayList<>();
        }

        return startPurchaseManualLottos(MANUAL_LOTTO_NUMBERS_QUESTION, numberOfManualLottos);
    }

    private List<Lotto> startPurchaseManualLottos(String question, int numberOfManualLottos) {
        outputQuestion(question);

        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < numberOfManualLottos; i++) {
            Lotto lotto = buyManualLotto();
            manualLottos.add(lotto);
        }

        return manualLottos;
    }

    private Lotto buyManualLotto() {
        String input = scanner.nextLine();
        input = removeAllEmptySpaces(input);

        while (!isValidInputLottoNumbersFormat(input) || !isValidLottoNumbers(input)) {
            outputQuestion(LOTTO_NUMBERS_DENIED);
            input = scanner.nextLine();
            input = removeAllEmptySpaces(input);
        }

        return Lotto.createLottoFrom(convertStringToListString(input));
    }

    public List<String> inputWinNumbers() {
        return confirmWinNumbers();
    }

    private List<String> confirmWinNumbers() {
        outputQuestion(WIN_NUMBERS_QUESTION);
        String input = scanner.nextLine();
        input = removeAllEmptySpaces(input);

        while(!isValidInputLottoNumbersFormat(input) || !isValidLottoNumbers(input)) {
            outputQuestion(LOTTO_NUMBERS_DENIED);
            input = scanner.nextLine();
            input = removeAllEmptySpaces(input);
        }

        return convertStringToListString(input);
    }

    private boolean isValidInputLottoNumbersFormat(String input) {
        return input.matches(VALID_LOTTO_NUMBER);
    }

    private boolean isValidLottoNumbers(String input) {
        String[] values = splitNumbersByComma(input);

        if (values.length != VALID_LOTTO_LENGTH) {
            return false;
        }

        int[] numbers = stringsToInts(values);
        return isValidWinNumber(numbers);
    }

    private String removeAllEmptySpaces(String input) {
        return input.replaceAll("\\s", "");
    }

    private List<String> convertStringToListString(String input) {
        return Arrays.asList(input.split(COMMA_DELIMITER));
    }

    private String[] splitNumbersByComma(String input) {
        return input.split(COMMA_DELIMITER);
    }

    private int[] stringsToInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private boolean isValidWinNumber(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] >= LOTTO_START_NUMBER && numbers[VALID_LOTTO_LENGTH - 1] <= LOTTO_END_NUMBER;
    }

    public int inputBonusNumber(List<String> winNumbers) {
        outputQuestion(BONUS_NUMBER_QUESTION);
        String input = scanner.nextLine();

        while (!isValidNumberInput(input) || !isValidBonusNumber(input) || !isNotDuplicatedFromWinNumbers(winNumbers, input)) {
            outputQuestion(BONUS_NUMBER_DENIED);
            input = scanner.nextLine();
        }

        return Integer.valueOf(input);
    }

    private boolean isNotDuplicatedFromWinNumbers(List<String> winNumbers, String bonusNumber) {
        return !winNumbers.contains(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        int bonusNumberAsInt = Integer.valueOf(bonusNumber);
        return bonusNumberAsInt >= LOTTO_START_NUMBER && bonusNumberAsInt <= LOTTO_END_NUMBER;
    }

}
