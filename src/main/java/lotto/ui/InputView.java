package lotto.ui;

import java.util.*;

public class InputView {

    private final static String PURCHASE_PRICE_MESSAGE = "구매입 금액을 입력하세요.";
    private final static String LAST_WEEKS_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력 하세요.";

    public static int inputPrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static List<Integer> inputLastWeeksWinningNumbers() {
        printLastWeeksWinningNumbersMessage();

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        return parseInts(split);
    }

    private static void printLastWeeksWinningNumbersMessage() {
        System.out.println();
        System.out.println(LAST_WEEKS_WINNING_NUMBERS_MESSAGE);
    }

    private static List<Integer> parseInts(String[] split) {
        List<Integer> lastWeeksWinningNumbers = new ArrayList<>();
        for (String s : split) {
            lastWeeksWinningNumbers.add(Integer.parseInt(s));
        }
        return lastWeeksWinningNumbers;
    }
}
