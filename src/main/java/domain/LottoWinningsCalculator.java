package domain;

import java.util.*;

public class LottoWinningsCalculator {
    private LottoWinningsCalculator() { }

    public static Price calculateWinnings(long equalCount, long lottoCount) {
        return Optional.ofNullable(LottoUnitWinnings.findWinningPrice(equalCount))
                .map(winningPrice -> winningPrice.multiple(lottoCount))
                .orElseGet(() -> new Price(0L));
    }
}
