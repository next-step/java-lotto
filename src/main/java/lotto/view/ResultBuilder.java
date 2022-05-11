package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.result.MatchStats;
import lotto.dto.result.PurchasedLotto;
import lotto.exception.NotSupportInstanceException;

import java.util.List;

public class ResultBuilder {

    private static final int EMPTY_SIZE = 0;
    private static final double BENCHMARK_PROFIT = 1.00;

    private static final String BLANK_LINE = "\n";
    private static final String MESSAGE_MATCH = "개 일치 ";
    private static final String MESSAGE_BRACKET_OPEN = "(";
    private static final String MESSAGE_BRACKET_CLOSE = ")";
    private static final String MESSAGE_DASH = " - ";
    private static final String MESSAGE_MATCH_COUNT_UNIT = "개";
    private static final String MESSAGE_TOTAL_PROFIT_RATE_INFO_START = "총 수익률은 ";
    private static final String MESSAGE_TOTAL_PROFIT_RATE_INFO_FINISH = "입니다.";
    private static final String MESSAGE_PROFIT_MINUS = "기준이 1이기 때문에 결과적으로 손해라는 의미임";
    private static final String MESSAGE_PROFIT_PLUS = "기준이 1이기 때문에 결과적으로 이익이라는 의미임";
    private static final String MESSAGE_PROFIT_NONE = "기준이 1이기 때문에 결과적으로 원점이라는 의미임";

    private static final StringBuilder sb = new StringBuilder();


    private ResultBuilder() {
        throw new NotSupportInstanceException();
    }

    public static String buildLottosInfo(List<PurchasedLotto> purchasedLottos) {
        initializeStringBuilder();

        for (PurchasedLotto lotto : purchasedLottos) {
            sb.append(lotto.lottoNumbers());
            sb.append(BLANK_LINE);
        }
        return sb.toString();
    }

    public static String buildLottosResult(List<MatchStats> matchStatsList) {
        initializeStringBuilder();

        for (MatchStats matchStats : matchStatsList) {
            sb.append(matchStats.matchResult().matchCount());
            sb.append(MESSAGE_MATCH);
            sb.append(MESSAGE_BRACKET_OPEN);
            sb.append(matchStats.matchResult().winPrice());
            sb.append(MESSAGE_BRACKET_CLOSE);
            sb.append(MESSAGE_DASH);
            sb.append(matchStats.count());
            sb.append(MESSAGE_MATCH_COUNT_UNIT);
            sb.append(BLANK_LINE);
        }
        return sb.toString();
    }

    public static String buildLottosProfitRate(double profitRate) {
        initializeStringBuilder();

        sb.append(MESSAGE_TOTAL_PROFIT_RATE_INFO_START);
        sb.append(String.format("%.2f", profitRate));
        sb.append(MESSAGE_TOTAL_PROFIT_RATE_INFO_FINISH);
        sb.append(MESSAGE_BRACKET_OPEN);
        sb.append(profitResultMessage(profitRate));
        sb.append(MESSAGE_BRACKET_CLOSE);
        return sb.toString();
    }

    private static String profitResultMessage(double profitRate) {
        if (profitRate < BENCHMARK_PROFIT) {
            return MESSAGE_PROFIT_MINUS;
        }
        if (profitRate == BENCHMARK_PROFIT) {
            return MESSAGE_PROFIT_NONE;
        }
        return MESSAGE_PROFIT_PLUS;
    }

    private static void initializeStringBuilder() {
        if (sb.length() > EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }
}
