package lotto.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int STANDARD = 1000;
    private static final String PATTERN = ", ";

    private InputView(){}

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String text = SCANNER.nextLine();
        return checkNum(text);
    }

    public static int isMorThanStandard(int number) {
        if (number % STANDARD != 0) {
            throw new InputMismatchException("1000원대만 결재가능합니다");
        }
        return number / STANDARD;
    }

    public static List<Integer> inputWiningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String text = SCANNER.nextLine();
        return checkNumbers(splitText(text));
    }

    private static List<Integer> checkNumbers(String[] textList) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < textList.length; i++) {
            numList.add(checkNum(textList[i]));
        }
        return numList;
    }

    private static int checkNum(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException err) {
            throw new NumberFormatException("숫자만 입력이 가능합니다");
        }
    }

    private static String[] splitText(String text) {
        return text.split(PATTERN);
    }

}
