package camp.nextstep.edu.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);

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
        List<Integer> candidates = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(candidates);
        List<Integer> selectedNumbers = candidates.subList(0, 6);
        return new HashSet<>(selectedNumbers);
    }
}
