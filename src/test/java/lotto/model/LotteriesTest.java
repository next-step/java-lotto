package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LotteriesTest {

    @Test
    void throwExceptionWhenLotteriesSizeLowwer6() {
        Set<Lottery> lotteries = new HashSet<>();
        lotteries.add(new Lottery(Number.of(5)));
        new Lotteries()
    }
}
