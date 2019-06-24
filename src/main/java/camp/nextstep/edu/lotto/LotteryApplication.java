package camp.nextstep.edu.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryApplication {

    private static final NaturalNumber PRICE_OF_LOTTERY = NaturalNumber.from(1000);
    private static final int SIZE = 6;
    private static final int ZERO = 0;
    private static final List<Integer> CANDIDATE_NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public NaturalNumber calculateNumberOfAvailableLotteries(NaturalNumber investment) {
        if (investment == null) {
            throw new IllegalArgumentException("'investment' must not be null");
        }
        return investment.divideBy(PRICE_OF_LOTTERY);
    }

    public List<Set<Integer>> purchase(NaturalNumber numberOfLotteries) {
        final int value = numberOfLotteries.value();
        return IntStream.range(0, value)
                .mapToObj(number -> createLottery())
                .collect(Collectors.toList());
    }

    public Set<Integer> createLottery() {
        final List<Integer> allNumbers = new ArrayList<>(CANDIDATE_NUMBERS);
        Collections.shuffle(allNumbers);
        final List<Integer> selectedNumbers = allNumbers.subList(ZERO, SIZE);
        return new HashSet<>(selectedNumbers);
    }
}
