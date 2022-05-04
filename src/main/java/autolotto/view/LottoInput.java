package autolotto.view;

import autolotto.domain.LottoNumberPattern;
import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInput {
    public static final String AMOUNT_QUESTION = "구입 금액을 입력해주세요. ex. 14000";
    public static final String WINNING_NUMBER_QUESTION = "지난주 당첨 번호를 콤마(,)를 기준으로 입력해주세요. ex. 1,2,3,4,5,6";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private final LottoNumberPattern lottoNumberPattern;

    public LottoInput() {
        this.lottoNumberPattern = new LottoNumberPattern();
    }

    public int askAmount() {
        System.out.println(AMOUNT_QUESTION);
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }

        return purchaseAmount;
    }

    public Set<Integer> askWinningNumber() {
        System.out.println(WINNING_NUMBER_QUESTION);
        String winningNumberInput = scanner.nextLine();

        List<String> splitedNumbers = Arrays.stream(winningNumberInput.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        boolean isNumber = splitedNumbers.stream()
                .allMatch(lottoNumberPattern::match);

        if (!isNumber) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE, winningNumberInput);
        }

        return splitedNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public int askBonusBall(Set<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBallInput = scanner.nextLine();

        boolean isNumber = lottoNumberPattern.match(bonusBallInput);
        if (!isNumber) {
            throw new LottoException(LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE, bonusBallInput);
        }

        int bonusBall = Integer.parseInt(bonusBallInput);

        if (winningNumbers.contains(bonusBall)) {
            throw new LottoException(LottoExceptionCode.DUPLICATED_LOTTO_NUMBER, bonusBallInput);
        }
        return bonusBall;
    }
}
