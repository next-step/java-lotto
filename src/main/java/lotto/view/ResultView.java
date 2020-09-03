package lotto.view;

import lotto.context.Message;
import lotto.context.Rank;
import lotto.domain.LottoPaper;
import lotto.util.MessageUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_PAPER_JOINING_DELIMITER = "\n";
    private static final List<String> BONUS_RANK_NAME =  new ArrayList<String>(){{
        add(Rank.SECOND.name());
    }};

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

    public static void showInputBonusNumber() {
        print(MessageUtil.getMsg(Message.INPUT_BONUS_NUMBER));
    }

    public static void showResult(Map<Rank, Integer> matchCountResult) {
        print("");
        print(MessageUtil.getMsg(Message.RESULT_HEAD));
        matchCountResult.entrySet().stream().forEach(entry -> {
            List<String> listParam = Arrays.asList(String.valueOf(entry.getKey().getCountOfMatch()),
                    String.valueOf(entry.getKey().getWinningMoney()),
                    String.valueOf(entry.getValue()),
                    isBonusBall(entry) ? "/ 보너스 볼 일치" : ""
                    );
            print(MessageUtil.getMsg(Message.RESULT_BODY, listParam));
        });
    }

    private static boolean isBonusBall(Map.Entry<Rank, Integer> rank) {
        return BONUS_RANK_NAME.contains(rank.getKey().name());
    }

    public static void showDelimiter() {
        print(MessageUtil.getMsg(Message.RESULT_DELIMITER));
    }

    public static void showEarningsRate(Double earningsRate) {
        print(MessageUtil.getMsg(Message.RESULT_EARNING_RATE, earningsRate.toString()));
    }
}
