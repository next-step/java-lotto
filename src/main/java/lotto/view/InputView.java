package lotto.view;

import lotto.domain.PurchaseInfo;
import lotto.exception.InvalidInputException;
import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_LIST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String VALIDATE_NULL_OR_EMPTY_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";
    private static final String VALIDATE_BONUS_NUMBER = "보너스 볼은 1 ~ 45 숫자 1개만 입력할 수 있습니다.";

    private InputView() {
        throw new AssertionError();
    }

    public static PurchaseInfo inputPurchaseInfo() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String inputPurchasePrice = SCANNER.next();
        System.out.println(MANUAL_AMOUNT_MESSAGE);
        String inputManualAmount = SCANNER.next();
        return new PurchaseInfo(convertToInt(validateInput(inputPurchasePrice)), convertToInt(validateInput(inputManualAmount)));
    }

    public static List<List<Integer>> getManualNumberList(Integer manualAmount) {
        System.out.println(MANUAL_NUMBER_MESSAGE);
        List<List<Integer>> manualNumberList = new ArrayList<>();
        for (int i = 0; i < manualAmount; i++) {
            String inputNumberList = SCANNER.next();
            manualNumberList.add(validateNumberList(inputNumberList));
        }
        return manualNumberList;
    }

    public static List<Integer> inputWinnerNumberList() {
        System.out.println(WINNER_NUMBER_LIST_MESSAGE);
        String inputNumberList = SCANNER.next();
        return validateNumberList(inputNumberList);
    }

    public static Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String inputBonus = SCANNER.next();
        return validateBonusNumber(inputBonus);
    }

    private static Integer validateBonusNumber(String inputBonus) {
        Integer bonusNumber = convertToInt(validateInput(inputBonus));
        if (!NumberUtil.defaultNumberList().contains(bonusNumber)) {
            throw new InvalidInputException(VALIDATE_BONUS_NUMBER);
        }
        return bonusNumber;
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

    private static List<Integer> validateNumberList(String inputNumberList) {
        return Arrays.stream(inputNumberList.trim().split(","))
                .map(InputView::validateInput)
                .map(InputView::convertToInt)
                .collect(Collectors.toList());
    }

}
