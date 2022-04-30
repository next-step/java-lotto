package lotto.view;

import lotto.domain.Lotto;
import lotto.exception.NotSupportInstanceException;

import java.util.List;

public class ResultBuilder {

    private static final String BLANK_LINE = "\n";
    private static final int EMPTY_SIZE = 0;
    private static final StringBuilder sb = new StringBuilder();

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

    private static void initializeStringBuilder() {
        if (sb.length() > EMPTY_SIZE) {
            sb.setLength(EMPTY_SIZE);
        }
    }
}
