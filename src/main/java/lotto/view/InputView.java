package lotto.view;

import lotto.dto.LotteryPurchaseRequest;
import lotto.dto.LotteryNumberListDto;
import lotto.dto.WinningLotteryNumbersRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTERY_NUMBER_SEPARATOR = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static LotteryPurchaseRequest getLotteryGenerateInput() {
        return new LotteryPurchaseRequest(getAmountOfMoneyToGenerateLottery(), getListOfManualLotteryNumberList());
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

    private static List<LotteryNumberListDto> getListOfManualLotteryNumberList() {
        int manualLotteryCount = getManualLotteryCount();
        List<LotteryNumberListDto> list = new ArrayList<>();
        System.out.println(MessageConstant.MANUAL_LOTTERY_NUMBER_INPUT);
        for (int i = 0; i < manualLotteryCount; i++) {
            list.add(new LotteryNumberListDto(getLotteryNumberList()));
        }
        return list;
    }

    private static int getManualLotteryCount() {
        System.out.println(MessageConstant.MANUAL_LOTTERY_COUNT_INPUT);
        String manualLotteryCountInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(manualLotteryCountInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getManualLotteryCount();
        }
    }

    private static List<Integer> getLotteryNumberList() {
        String[] numberListInString = SCANNER.nextLine()
                .trim().split(LOTTERY_NUMBER_SEPARATOR);
        try {
            return Arrays.stream(numberListInString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getLotteryNumberList();
        }
    }
    public static WinningLotteryNumbersRequest getWinningLotteryNumberInput() {
        return new WinningLotteryNumbersRequest(getWinningLotteryNumberList(), getBonusNumber());
    }

    private static List<Integer> getWinningLotteryNumberList() {
        System.out.println(MessageConstant.LAST_WINNING_LOTTERY_NUMBER_INPUT);
        return getLotteryNumberList();
    }

    private static int getBonusNumber() {
        System.out.println(MessageConstant.BONUS_NUMBER_INPUT);
        String bonusNumberInString = SCANNER.nextLine();
        try {
            return Integer.parseInt(bonusNumberInString);
        } catch (NumberFormatException ex) {
            printWrongInputMessage();
            return getBonusNumber();
        }
    }

    public static void printWrongInputMessage() {
        System.out.println(MessageConstant.WRONG_INPUT);
    }

}
