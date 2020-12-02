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

        return parseInts(split);
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
