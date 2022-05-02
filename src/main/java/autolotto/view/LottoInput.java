package autolotto.view;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoInput {
    public static final String AMOUNT_QUESTION = "구입 금액을 입력해주세요. ex. 14000";
    public static final String WINNING_NUMBER_QUESTION = "지난주 당첨 번호를 콤마(,)를 기준으로 입력해주세요. ex. 1,2,3,4,5,6";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5]");
    private static final String DELIMITER = ",";

    public int askAmount(String question) {
        System.out.println(question);

        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return purchaseAmount;
    }

    public Set<Integer> askWinningNumber(String question) {
        System.out.println(question);
        String winningNumberInput = scanner.nextLine();

        List<String> splitedNumbers = Arrays.stream(winningNumberInput.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        boolean isNumber = splitedNumbers.stream()
                .allMatch(number -> NUMBER_PATTERN.matcher(number).matches());

        if (!isNumber) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE, winningNumberInput);
        }

        return splitedNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
