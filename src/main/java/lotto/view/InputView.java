package lotto.view;

import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String MATCH_NUMBER_LIST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String VALIDATE_NULL_OR_EMPTY_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";
    private static final Integer MATCH_NUMBER_LIST_SIZE = 6;
    private static final String VALIDATE_MATCH_NUMBER_SIZE_MESSAGE = "당첨 번호는 중복되지 않는 " + MATCH_NUMBER_LIST_SIZE + "개 숫자를 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static Integer inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String input = SCANNER.next();
        return convertToInt(validateInput(input));
    }

    public static List<Integer> inputMatchNumberList() {
        System.out.println(MATCH_NUMBER_LIST_MESSAGE);
        String input = SCANNER.next();
        System.out.println();
        return validateMatchNumberList(Arrays.stream(input.trim().split(","))
                .map(InputView::validateInput)
                .map(InputView::convertToInt)
                .collect(Collectors.toList()));
    }

    private static List<Integer> validateMatchNumberList(List<Integer> matchNumberList) {
        if (!(new HashSet<>(matchNumberList).size() == MATCH_NUMBER_LIST_SIZE)) {
            throw new InvalidInputException(VALIDATE_MATCH_NUMBER_SIZE_MESSAGE);
        }
        return matchNumberList;
    }

    private static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(VALIDATE_NULL_OR_EMPTY_MESSAGE);
        }
        return input;
    }

    private static Integer convertToInt(String purchaseAmount) {
        try {
            int parseInt = Integer.parseInt(purchaseAmount);
            if (parseInt <= 0) {
                throw new InvalidInputException(VALIDATE_INTEGER);
            }
            return parseInt;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(VALIDATE_INTEGER);
        }
    }

}
