package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.PurchasePrice;
import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String MATCH_NUMBER_LIST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String VALIDATE_NULL_OR_EMPTY_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";

    private InputView() {
        throw new AssertionError();
    }

    public static PurchasePrice inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String input = SCANNER.next();
        return new PurchasePrice(convertToInt(validateInput(input)));
    }

    public static LottoNumbers inputMatchNumberList() {
        System.out.println(MATCH_NUMBER_LIST_MESSAGE);
        String input = SCANNER.next();
        System.out.println();
        return new LottoNumbers(Arrays.stream(input.trim().split(","))
                .map(InputView::validateInput)
                .map(InputView::convertToInt)
                .collect(Collectors.toList()));
    }

    private static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(VALIDATE_NULL_OR_EMPTY_MESSAGE);
        }
        return input;
    }

    private static Integer convertToInt(String number) {
        try {
            int parseInt = Integer.parseInt(number);
            if (parseInt <= 0) {
                throw new InvalidInputException(VALIDATE_INTEGER);
            }
            return parseInt;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(VALIDATE_INTEGER);
        }
    }

}
