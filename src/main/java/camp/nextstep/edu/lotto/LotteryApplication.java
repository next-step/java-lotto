package camp.nextstep.edu.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int SIZE = 6;
    private static final int ZERO = 0;

    public NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    public List<Set<Integer>> purchase(NaturalNumber numberOfLotteries) {
        final int value = numberOfLotteries.value();
        return IntStream.range(0, value)
                .mapToObj(number -> new HashSet<Integer>())
                .collect(Collectors.toList());
    }

    public Set<Integer> createLottery() {
        final List<Integer> candidates = IntStream.rangeClosed(BEGIN_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(candidates);
        final List<Integer> selectedNumbers = candidates.subList(ZERO, SIZE);
        return new HashSet<>(selectedNumbers);
    }
}
