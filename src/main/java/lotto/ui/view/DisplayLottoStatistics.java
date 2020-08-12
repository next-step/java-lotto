package lotto.ui.view;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoWinningAndPrizeMoney;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static lotto.domain.LottoWinningAndPrizeMoney.FIFTH;
import static lotto.domain.LottoWinningAndPrizeMoney.FIRST;
import static lotto.domain.LottoWinningAndPrizeMoney.FOURTH;
import static lotto.domain.LottoWinningAndPrizeMoney.SECOND;
import static lotto.domain.LottoWinningAndPrizeMoney.THIRD;
import static lotto.ui.LottoDisplay.NEW_LINE;

public class DisplayLottoStatistics {
    private final LottoStatistics statistics;

    private static final Set<LottoWinningAndPrizeMoney> orderd;
    static {
        Set<LottoWinningAndPrizeMoney> temp = new LinkedHashSet<>();
        temp.add(FIFTH);
        temp.add(FOURTH);
        temp.add(THIRD);
        temp.add(SECOND);
        temp.add(FIRST);
        orderd = Collections.unmodifiableSet(temp);
    }

    public DisplayLottoStatistics(LottoStatistics statistics) {
        this.statistics = statistics;
    }

    public String format(LottoWinningAndPrizeMoney lottoWinningAndPrizeMoney){
        return String.format("%d개 일치 (%10d원)- %2d개"
            , lottoWinningAndPrizeMoney.getCountOfMatch()
            , lottoWinningAndPrizeMoney.getPrizeMoney()
            , statistics.getTotalMatchCount(lottoWinningAndPrizeMoney)
        );
    }

    @Override
    public String toString() {
        return String.join(NEW_LINE
            , displayPrizeMoney()
            , displayGrossProfit()
        );
    }

    private String displayPrizeMoney() {
        return orderd.stream()
                     .map(this::format)
            .collect(joining(NEW_LINE));
    }

    private String displayGrossProfit() {
        return String.format("총 수익률은 %.2f 입니다", statistics.getGrossProfit());
    }
}
