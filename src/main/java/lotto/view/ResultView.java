package lotto.view;

import lotto.context.Message;
import lotto.context.Rank;
import lotto.domain.LottoPaper;
import lotto.util.MessageUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_PAPER_JOINING_DELIMITER = "\n";

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printInputMsg() {
        ResultView.print(MessageUtil.getMsg(Message.INPUT_MSG));
    }

    public static void showLottoNumbersList(List<LottoPaper> papers) {
        print(papers.stream()
                .map(LottoPaper::toString)
                .collect(Collectors.joining(LOTTO_PAPER_JOINING_DELIMITER)));
    }

    public static void showBuyCount(Integer papersCount) {
        print(MessageUtil.getMsg(Message.BUY_COUNT, papersCount.toString()));
    }

    public static void showInputWinningNumber() {
        print("");
        print(MessageUtil.getMsg(Message.INPUT_WINNING_NUMBER));
    }

    public static void showResult(Map<Rank, Integer> matchCountResult) {
        print("");
        print(MessageUtil.getMsg(Message.RESULT_HEAD));
        matchCountResult.entrySet().stream().forEach(entry -> {
            List<String> listParam = Arrays.asList(String.valueOf(entry.getKey().getCountOfMatch()),
                    String.valueOf(entry.getKey().getWinningMoney()),
                    String.valueOf(entry.getValue()));
            print(MessageUtil.getMsg(Message.RESULT_BODY, listParam));
        });
    }

    public static void showDelimiter() {
        print(MessageUtil.getMsg(Message.RESULT_DELIMITER));
    }

    public static void showEarningsRate(Double earningsRate) {
        print(MessageUtil.getMsg(Message.RESULT_EARNING_RATE, earningsRate.toString()));
    }
}
