package camp.nextstep.edu.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);

    public NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    public List<Set<Integer>> purchase(NaturalNumber numberOfLotteries) {
        return Collections.emptyList();
    }
}
