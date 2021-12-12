package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWin {

    FIRST(6, 2000000000L),
    SECOND(5, 1500000L),
    THIRD(4, 50000L),
    FOURTH(3, 5000L),
    DEFAULT(-1, 0)
    ;

    private final int numberOfMatch;
    private final Money winPrice;

    LottoWin(int numberOfMatch, long winPrice) {
        this.numberOfMatch = numberOfMatch;
        this.winPrice = new Money(winPrice);
    }

    public static final List<LottoWin> LOTTO_WINS = Stream.of(FOURTH, THIRD, SECOND, FIRST)
            .collect(Collectors.toList());

    public static LottoWin of(int matchCount) {
        return LOTTO_WINS.stream()
                .filter(lottoWin -> lottoWin.numberOfMatch == matchCount)
                .findFirst()
                .orElse(DEFAULT)
                ;
    }

    public static Money winPriceOf(int matchCount) {
        LottoWin win = of(matchCount);
        return win.winPrice;
    }

    public int numberOfMatch() {
        return this.numberOfMatch;
    }

    public Money winPrice() {
        return this.winPrice;
    }

}
