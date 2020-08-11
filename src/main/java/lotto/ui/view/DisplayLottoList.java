package lotto.ui.view;

import java.util.Collection;

import lotto.domain.core.Lotto;

import static java.util.stream.Collectors.joining;
import static lotto.ui.LottoDisplay.NEW_LINE;

public class DisplayLottoList {

    public static final String LOTTO_SET_PREFIX = "[";
    public static final String LOTTO_SET_DELIMITER = ", ";
    public static final String LOTTO_SET_SUFFIX = "]";

    private final Collection<Lotto> lottos;

    public DisplayLottoList(Collection<Lotto> lottos) {
        this.lottos = lottos;
    }

    private String toLottoString(Lotto lottos){
        return lottos.getPrimitiveLottoNos()
                     .stream()
                     .map(l -> String.format("%2d", l))
                     .collect(joining(LOTTO_SET_DELIMITER, LOTTO_SET_PREFIX, LOTTO_SET_SUFFIX))
            ;
    }

    @Override
    public String toString() {
        return lottos.stream()
                        .map(this::toLottoString)
                        .collect(joining(NEW_LINE))
            ;
    }
}
