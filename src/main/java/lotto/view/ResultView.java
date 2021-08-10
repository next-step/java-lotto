package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningRank;

import java.io.PrintStream;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String MESSAGE_BOUNDARY = "---------";
    private static final String ANSWER_COUNT_MESSAGE = "%d개 일치";
    private static final String BONUS_BALL_MATCH_MESSAGE = "보너스 볼 일치";
    private static final String WINNING_MONEY_AMOUNT_MESSAGE = "(%d원)";
    private static final String EQUAL_WINNING_RANK_COUNT_MESSAGE = "%d개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String DASH = "-";
    private static final String COMMA = ",";

    private final PrintStream printStream;

    public ResultView() {
        this.printStream = System.out;
    }

    public void printLottoCount(int lottoCount) {
        printStream.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printStream.println(lotto);
        }
        printStream.println();
    }

    public void printWinningStatistics(int purchaseAmount, List<WinningRank> myWinningRanks) {
        printStream.println(WINNING_STATISTICS_MESSAGE);
        printStream.println(MESSAGE_BOUNDARY);

        int earning = 0;
        WinningRank[] allWinningRanks = WinningRank.values();

        for (int i = allWinningRanks.length - 1; i >= 0; i--) {
            WinningRank winningRank = allWinningRanks[i];
            int equalWinningRankCount = getEqualWinningRankCount(myWinningRanks, winningRank);
            earning += winningRank.getWinningMoneyAmount() * equalWinningRankCount;

            printStream.println(getWinningStatisticsMessage(winningRank, equalWinningRankCount));
        }
        printStream.println(String.format(EARNING_RATE_MESSAGE, (float) earning / purchaseAmount));
    }

    private int getEqualWinningRankCount(List<WinningRank> myWinningRanks, WinningRank winningRank) {
        return myWinningRanks.stream()
                .filter(myWinningRank -> myWinningRank == winningRank)
                .collect(toList())
                .size();
    }

    private String getWinningStatisticsMessage(WinningRank winningRank, int equalWinningRankCount) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ANSWER_COUNT_MESSAGE);
        stringBuffer.append(ONE_BLANK_SPACE);
        if (winningRank.isSecondPlace()) {
            stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(ONE_BLANK_SPACE));
            stringBuffer.append(COMMA);
            stringBuffer.append(ONE_BLANK_SPACE);
            stringBuffer.append(BONUS_BALL_MATCH_MESSAGE);
        }
        stringBuffer.append(WINNING_MONEY_AMOUNT_MESSAGE);
        stringBuffer.append(DASH);
        stringBuffer.append(ONE_BLANK_SPACE);
        stringBuffer.append(EQUAL_WINNING_RANK_COUNT_MESSAGE);
        return String.format(stringBuffer.toString(), winningRank.getMatchedWinningNumberCount()
                , winningRank.getWinningMoneyAmount(), equalWinningRankCount);
    }

    public void printNewLine() {
        printStream.println();
    }
}
