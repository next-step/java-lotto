package lotto.view.formatter;

import lotto.common.Symbol;
import lotto.domain.LottoCount;

public class OutputFomatter {

    public static final String MOVEMENT_MARK = Symbol.HYPHEN;
    public static final String WINNERS_SEPARATOR = Symbol.COMMA;

    public int toLottoCount(LottoCount lottoCount) {
        return lottoCount.getLottoCount();
    }
}
