package lotto.view;

import lotto.dto.OrderResponse;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPaper;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String RESULT_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f 입니다.";

    public void printOrderResponse(OrderResponse response) {
        StringBuilder sb = new StringBuilder();

        sb.append(response.getQuantity()).append("개를 구매했습니다").append(NEW_LINE);
        for (Lotto lotto : response.getLottos()) {
            sb.append(lotto.toJoinNumber(DELIMITER, PREFIX, SUFFIX)).append(NEW_LINE);
        }

        System.out.println(sb);
    }

    public void printResult(OrderResponse response, List<LottoNumber> winningNumbers) {
        StringBuilder sb = new StringBuilder();

        int quantity = response.getQuantity();
        LottoPaper lottoPaper = response.getLottoPaper();
        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        appendPrefix(sb);
        appendResult(resultMap, sb);
        appendRateOfReturn(resultMap, quantity, sb);

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
            int matchedCount = resultMap.getOrDefault(ballCount, 0);

            String text = String.format(RESULT_FORMAT, ballCount, reward, matchedCount);
            sb.append(text).append(NEW_LINE);
        }
    }

    private void appendRateOfReturn(Map<Integer, Integer> resultMap, int quantity, StringBuilder sb) {
        sb.append(String.format(RATE_OF_RETURN_FORMAT, Rank.rateOfReturn(resultMap, quantity)));
    }
}
