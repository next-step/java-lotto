package lotto.view;

import lotto.model.Rank;

import java.util.Map;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RESULT_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f 입니다.";

    public void print(Map<Integer, Integer> resultMap, int money) {
        StringBuilder sb = new StringBuilder();

        appendPrefix(sb);
        appendResult(resultMap, sb);
        appendRateOfReturn(resultMap, money, sb);

        System.out.println(sb);
    }

    private void appendPrefix(StringBuilder sb) {
        sb.append("당첨 통계").append(NEW_LINE);
        sb.append("---------").append(NEW_LINE);
    }

    private void appendResult(Map<Integer, Integer> resultMap, StringBuilder sb) {
        for (Rank rank : Rank.ranks()) {
            int ballCount = rank.getBallCount();
            int reward = rank.getReward();
            int matchedCount = resultMap.getOrDefault(rank.getBallCount(), 0);

            String text = String.format(RESULT_FORMAT, ballCount, reward, matchedCount);
            sb.append(text).append(NEW_LINE);
        }
    }

    private void appendRateOfReturn(Map<Integer, Integer> resultMap, int money, StringBuilder sb) {
        sb.append(String.format(RATE_OF_RETURN_FORMAT, Rank.rateOfReturn(resultMap, money)));
    }
}
