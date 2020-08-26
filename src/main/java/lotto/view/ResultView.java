package lotto.view;

import lotto.context.Message;
import lotto.context.Rank;
import lotto.util.MessageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultView {
    private ResultView() {
        throw new AssertionError();
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printNextLine() {
        System.out.println("");
    }

    public static void printInputMsg() {
        ResultView.print(MessageUtil.getMsg(Message.INPUT_MSG));
    }

    public static void printBuyCount(Integer papersCount) {
        print(MessageUtil.getMsg(Message.BUY_COUNT, papersCount.toString()));
    }

    public static void printInputWinningNumber() {
        printNextLine();
        print(MessageUtil.getMsg(Message.INPUT_WINNING_NUMBER));
    }

    public static void printResult(Map<Rank, Integer> matchCountResult) {
        print("");
        print(MessageUtil.getMsg(Message.RESULT_HEAD));
        matchCountResult.entrySet().stream().forEach(entry -> {
            List<String> listParam = Arrays.asList(String.valueOf(entry.getKey().getCountOfMatch()),
                    String.valueOf(entry.getKey().getWinningMoney()),
                    String.valueOf(entry.getValue()));
            print(MessageUtil.getMsg(Message.RESULT_BODY, listParam));
        });
    }

    public static void printDelimiter() {
        print(MessageUtil.getMsg(Message.RESULT_DELIMITER));
    }

    public static void printEarningsRate(Double earningsRate) {
        print(MessageUtil.getMsg(Message.RESULT_EARNING_RATE, earningsRate.toString()));
    }
}
