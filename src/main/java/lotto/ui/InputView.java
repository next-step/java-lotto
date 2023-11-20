package lotto.ui;

import lotto.domain.PurchaseQuantity;
import lotto.domain.strategy.ManualNumberGeneration;
import lotto.domain.strategy.NumberGeneration;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String PATTERN = ",";

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return checkNum(SCANNER.nextLine());
    }

    public static int inputManualCount() {
        printBlank();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return checkNum(SCANNER.nextLine());
    }

    public static List<NumberGeneration> inputManualList(PurchaseQuantity manual) {
        printBlank();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<NumberGeneration> list = new ArrayList<>();

        for (int i = 0; i < manual.find(); i++) {
            list.add(new ManualNumberGeneration(checkNumbers(checkListSize(splitText(SCANNER.nextLine())))));
        }

        return list;
    }

    public static NumberGeneration inputWiningNumbers() {
        printBlank();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String text = SCANNER.nextLine();
        return new ManualNumberGeneration(checkNumbers(checkListSize(splitText(text))));
    }

    public static int inputBonusBall() {
        printBlank();
        System.out.println("보너스 볼을 입력해 주세요.");
        return checkNum(SCANNER.nextLine());
    }


    private static int checkNum(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException err) {
            throw new NumberFormatException("숫자만 입력이 가능합니다");
        }
    }

    private static List<Integer> checkNumbers(String[] textList) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < textList.length; i++) {
            numList.add(checkNum(textList[i]));
        }
        return numList;
    }

    private static String[] checkListSize(String[] textArray) {
        if (textArray.length != 6) {
            throw new InputMismatchException("번호는 6개여야 합니다");
        }
        return textArray;

    }

    private static String[] splitText(String text) {
        return text.replaceAll(" ", "").split(PATTERN);
    }

    private static void printBlank() {
        System.out.println();
    }

}
