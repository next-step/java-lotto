package lotto.view;

import lotto.domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class InputView {

    private static final InputView INPUT_VIEW = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String RESULT_PURCHASE_AMOUNT = "%s개를 구매했습니다.%n";
    private static final String INPUT_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final int CASH_UNIT = 1000;

    public static synchronized InputView getInstance() {
        if (INPUT_VIEW == null) {
            return new InputView();
        }
        return INPUT_VIEW;
    }

    private InputView() {

    }

    public int inputPurchaseAmount() {
        out.println(INPUT_PURCHASE_AMOUNT);
        String input = scanner.next();
        int purchaseAmount = Integer.parseInt(input);

        out.printf(RESULT_PURCHASE_AMOUNT, purchaseAmount / CASH_UNIT);
        return purchaseAmount;
    }

    public List<Number> inputWinnerNumbers() {
        out.println(INPUT_WINNER_NUMBER);
        String input = scanner.next();
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> inputBonusNumber() {
        out.println(INPUT_BONUS_NUMBER);
        String input = scanner.next();
        return Arrays.asList(new Number(Integer.parseInt(input)));
    }
}
