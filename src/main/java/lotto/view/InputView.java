package lotto.view;

import lotto.domain.LottoTicket;

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

    public static LottoTicket buyAndGenerateLottoNumbers(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");

        return new LottoTicket(lottoCount);
    }

    public static String inputAndValidateWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. ex) 1, 2, 3, 4, 5, 6");
        String inputWinningNumbers = SCANNER.nextLine();

        validateInputWinningNumbers(inputWinningNumbers);

        return inputWinningNumbers;
    }

    public static void validateInputWinningNumbers(String inputWinningNumbers) {
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

    public static List<Integer> extractNumbers(String splitExpression) {
        return splitInputExpression(splitExpression).stream()
                .filter(str -> str.matches("[0-9]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
