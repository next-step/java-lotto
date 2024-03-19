package lotto.view;

import lotto.dto.LottoNumberResponse;
import lotto.model.Prize;
import lotto.model.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();

    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String RESULT_FORMAT = "%s개 일치 (%s원) - %s개";
    private static final String BONUS_RESULT_FORMAT = "%s개 일치, 보너스 볼 일치(%s원) - %s개";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f 입니다.";

    public void printOrderResponse(List<LottoNumberResponse> responses) {
        StringBuilder sb = new StringBuilder();

        sb.append(responses.size()).append("개를 구매했습니다").append(NEW_LINE);
        for (LottoNumberResponse response : responses) {
            sb.append(toJoinNumbers(response.getNumbers())).append(NEW_LINE);
        }

        System.out.println(sb);
    }

    private String toJoinNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public void printResult(Prize prize, int quantity) {
        StringBuilder sb = new StringBuilder();

        appendPrefix(sb);
        appendResult(sb, prize);
        appendRateOfReturn(sb, prize.rateOfReturn(quantity));

        System.out.println(sb);
    }

    private void appendPrefix(StringBuilder sb) {
        sb.append("당첨 통계").append(NEW_LINE);
        sb.append("---------").append(NEW_LINE);
    }

    private void appendResult(StringBuilder sb, Prize prize) {
        for (Rank rank : Rank.ranks()) {
            int ballCount = rank.getBallCount();
            int reward = rank.getReward();
            int matchedCount = prize.rankCount(rank);

            String format = rank.isTwo() ? BONUS_RESULT_FORMAT : RESULT_FORMAT;
            String text = String.format(format, ballCount, reward, matchedCount);
            sb.append(text).append(NEW_LINE);
        }
    }

    private void appendRateOfReturn(StringBuilder sb, double rateOfReturn) {
        sb.append(String.format(RATE_OF_RETURN_FORMAT, rateOfReturn));
    }
}
