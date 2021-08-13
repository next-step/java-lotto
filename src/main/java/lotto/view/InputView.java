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

    public static synchronized InputView getInstance() {
        if (INPUT_VIEW == null) {
            return new InputView();
        }
        return INPUT_VIEW;
    }

    private InputView() {

    }

    public int inputPurchaseAmount() {
        out.println("구입금액을 입력해 주세요.");
        String input = scanner.next();
        int purchaseAmount = Integer.parseInt(input);

        out.println(purchaseAmount+"개를 구매했습니다.");
        return purchaseAmount;
    }

    public List<Number> inputWinnerNumbers() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.next();
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
