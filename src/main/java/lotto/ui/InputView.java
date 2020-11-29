package lotto.ui;

import lotto.Message;

import java.util.*;

public class InputView {

    public static int inputPrice() {
        System.out.println(Message.INPUT_PURCHASE_PRICE_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static List<Integer> inputLastWeeksWinningNumbers() {
        printLastWeeksWinningNumbersMessage();

        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        validateLastWeeksWinningNumbersSize(split);

        return parseInts(split);
    }

    private static void validateLastWeeksWinningNumbersSize(String[] values) {
        if (values.length != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6자리 입니다.");
        }
    }

    private static void printLastWeeksWinningNumbersMessage() {
        System.out.println();
        System.out.println(Message.INPUT_LAST_WEEKS_WINNING_NUMBERS_MESSAGE);
    }

    private static List<Integer> parseInts(String[] split) {
        List<Integer> lastWeeksWinningNumbers = new ArrayList<>();
        for (String s : split) {
            lastWeeksWinningNumbers.add(Integer.parseInt(s));
        }
        return lastWeeksWinningNumbers;
    }
}
