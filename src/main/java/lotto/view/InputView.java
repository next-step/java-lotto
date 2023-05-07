package lotto.view;

import lotto.domain.LottoAvailableNumber;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.strategy.ManualLottoNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int LOTTO_PRICE = 1_000;
    private static final String NUMBER_SPACE_COMMA_REGEX = "^[\\d\\s,]+$";
    private static final String COMMA_SPACE = ",\\s*";
    private static final String NUMBER = "\\d+";

    private InputView() {
    }

    public static int requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int requestPurchaseAmountByManual() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요. ex) 3");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static LottoTicket buyAndGenerateLottoNumbers(int purchaseAmount, int purchaseManualGeneratedLottoCount) {
        int autoGeneratedLottoCount = (purchaseAmount / LOTTO_PRICE) - purchaseManualGeneratedLottoCount;
        List<String> inputManualNumbers = inputAndValidateManualNumbers(purchaseManualGeneratedLottoCount);

        List<LottoNumber> manualLottoNumbers = inputManualNumbers.stream()
                .map(manualLottoNumber -> {
                    List<LottoAvailableNumber> extractNumbers = extractNumbers(manualLottoNumber);
                    return new LottoNumber(new ManualLottoNumberGenerateStrategy(extractNumbers));
                })
                .collect(Collectors.toList());

        LottoTicket lottoTicket = new LottoTicket(autoGeneratedLottoCount, manualLottoNumbers, purchaseAmount);
        System.out.println("수동으로 " + purchaseManualGeneratedLottoCount + "장 " + "자동으로 " + autoGeneratedLottoCount + "개를 구매했습니다.");
        return lottoTicket;
    }

    public static String inputAndValidateWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. ex) 1, 2, 3, 4, 5, 6");
        String inputWinningNumbers = SCANNER.nextLine();

        validateInputLottoNumbers(inputWinningNumbers);

        return inputWinningNumbers;
    }

    public static void validateInputLottoNumbers(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백인 문자입니다.");
        }

        if (!isNumberSpaceCommaExpression(inputWinningNumbers)) {
            throw new IllegalArgumentException("입력값의 형식이 올바르지 않습니다.");
        }

        if (!isSixNumber(inputWinningNumbers)) {
            throw new IllegalArgumentException("당첨 번호의 갯수를 확인해 주세요.");
        }
    }

    public static List<LottoAvailableNumber> extractNumbers(String splitExpression) {
        return splitInputExpression(splitExpression).stream()
                .filter(str -> str.matches("[0-9]+"))
                .map(Integer::parseInt)
                .map(LottoAvailableNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoAvailableNumber inputAndValidateBonusNumbers(List<LottoAvailableNumber> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요. ex) 1");

        int bonusNumber = SCANNER.nextInt();
        validateBonusNumber(winningNumbers, bonusNumber);

        return new LottoAvailableNumber(bonusNumber);
    }

    public static void validateBonusNumber(List<LottoAvailableNumber> winningNumbers, int bonusNumber) {
        boolean isWinningNumbersInBonusNumber = winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.getNumber() == bonusNumber);
        if (isWinningNumbersInBonusNumber) {
            throw new IllegalArgumentException("보너스 볼이 당첨번호에 포함되어 있습니다.");
        }
    }

    private static List<String> inputAndValidateManualNumbers(int lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            String lottoNumber = SCANNER.nextLine();

            validateInputLottoNumbers(lottoNumber);

            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    private static boolean isSixNumber(String inputWinningNumbers) {
        String[] numbers = inputWinningNumbers.split(COMMA_SPACE);

        return numbers.length == 6 && Arrays.stream(numbers)
                .allMatch(str -> str.matches(NUMBER));
    }

    private static boolean isNumberSpaceCommaExpression(String inputWinningNumbers) {
        return inputWinningNumbers.matches(NUMBER_SPACE_COMMA_REGEX);
    }

    private static List<String> splitInputExpression(String inputExpression) {
        return Arrays.asList(inputExpression.split(COMMA_SPACE));
    }

}
