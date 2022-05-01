package lotto.view;

import lotto.constant.MatchResult;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Lottos;
import lotto.exception.NotSupportInstanceException;

import java.util.List;

public class ResultBuilder {

    private static final String BLANK_LINE = "\n";
    private static final int EMPTY_SIZE = 0;
    private static final StringBuilder sb = new StringBuilder();
    private static final String MESSAGE_MATCH = "개 일치 ";
    private static final String MESSAGE_BRACKET_OPEN = "(";
    private static final String MESSAGE_BRACKET_CLOSE = ")";
    private static final String MESSAGE_DASH = " - ";
    private static final String MESSAGE_MATCH_COUNT_UNIT = "개";

    private ResultBuilder() {
        throw new NotSupportInstanceException();
    }

    public static String buildLottosInfo(List<Lotto> lottos) {
        initializeStringBuilder();

        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(BLANK_LINE);
        }
        return sb.toString();
    }

    public static String buildLottosResult(Lottos lottos) {
        initializeStringBuilder();

        for (MatchResult matchResult : MatchResult.values()) {
            sb.append(matchResult.matchCount());
            sb.append(MESSAGE_MATCH);
            sb.append(MESSAGE_BRACKET_OPEN);
            sb.append(matchResult.winPrice());
            sb.append(MESSAGE_BRACKET_CLOSE);
            sb.append(MESSAGE_DASH);
            sb.append(lottos.countMatchResult(matchResult));
            sb.append(MESSAGE_MATCH_COUNT_UNIT);
            sb.append(BLANK_LINE);
        }
        return sb.toString();
    }

    private static void initializeStringBuilder() {
        if (sb.length() > EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }
}
