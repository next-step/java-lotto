package lotto.view;

import lotto.dto.LotteryGenerateRequest;
import lotto.dto.WinningLotteryNumbersRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTERY_NUMBER_SEPARATOR = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static LotteryGenerateRequest getLotteryGenerateInput() {
        return new LotteryGenerateRequest(getAmountOfMoneyToGenerateLottery());
    }

    private static int getAmountOfMoneyToGenerateLottery() {
        System.out.println(MessageConstant.AMOUNT_INPUT);
        String amountInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(amountInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getAmountOfMoneyToGenerateLottery();
        }
    }

    public static WinningLotteryNumbersRequest getWinningLotteryNumberInput() {
        return new WinningLotteryNumbersRequest(getWinningLotteryNumberList());

    }

    private static List<Integer> getWinningLotteryNumberList() {
        System.out.println(MessageConstant.LAST_WINNING_LOTTERY_NUMBER_INPUT);
        String[] numberListInString = SCANNER.nextLine().trim().split(LOTTERY_NUMBER_SEPARATOR);
        try {
            return Arrays.stream(numberListInString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getWinningLotteryNumberList();
        }
    }


    public static void printWrongInputMessage() {
        System.out.println(MessageConstant.WRONG_INPUT);
    }

}
