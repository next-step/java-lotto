package lotto.view;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.util.NumberUtil.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PURCHASE_PRICE_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_LIST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static Integer inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        String inputPurchasePrice = SCANNER.nextLine();
        return convertNumberStringToInt(inputPurchasePrice);
    }

    public static Integer inputManualAmount() {
        System.out.println(MANUAL_AMOUNT_MESSAGE);
        String inputManualAmount = SCANNER.nextLine();
        return convertAmountStringToInt(inputManualAmount);
    }

    public static List<List<Integer>> getManualNumberList(Integer manualAmount) {
        if (manualAmount == 0) {
            return null;
        }

        System.out.println(MANUAL_NUMBER_MESSAGE);
        List<List<Integer>> manualNumberList = new ArrayList<>();
        for (int i = 0; i < manualAmount; i++) {
            String inputNumberList = SCANNER.nextLine();
            manualNumberList.add(validateNumberList(inputNumberList));
        }
        return manualNumberList;
    }

    public static List<Integer> inputWinnerNumberList() {
        System.out.println(WINNER_NUMBER_LIST_MESSAGE);
        String inputNumberList = SCANNER.nextLine();
        return validateNumberList(inputNumberList);
    }

    public static Integer inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String inputBonus = SCANNER.nextLine();
        return convertNumberStringToInt(inputBonus);
    }

    private static List<Integer> validateNumberList(String inputNumberList) {
        String trimmedInputNumberList = inputNumberList.replaceAll(" ", "");
        return Arrays.stream(trimmedInputNumberList.split(","))
                .map(NumberUtil::convertNumberStringToInt)
                .collect(Collectors.toList());
    }

}
