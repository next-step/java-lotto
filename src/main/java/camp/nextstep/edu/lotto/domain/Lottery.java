package camp.nextstep.edu.lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Lottery {
    private static final int SIZE = 6;
    private static final int ZERO = 0;

    private final Set<LotteryNumber> numberSet;

    private Lottery(Set<LotteryNumber> numberSet) {
        if (numberSet == null) {
            throw new IllegalArgumentException("'numberSet' must not be null");
        }
        if (numberSet.size() != SIZE) {
            throw new IllegalArgumentException("size of 'numberSet' must be equal to " + SIZE);
        }
        this.numberSet = new HashSet<>(numberSet);
    }

    public static Lottery randomizedInstance() {
        final List<LotteryNumber> allNumbers = LotteryNumber.allNumbers();
        Collections.shuffle(allNumbers);
        final List<LotteryNumber> selectedNumbers = allNumbers.subList(ZERO, SIZE);
        final Set<LotteryNumber> selectedNumberSet = new HashSet<>(selectedNumbers);
        return new Lottery(selectedNumberSet);
    }

    public static Lottery customizedInstance(Set<LotteryNumber> numberSet) {
        return new Lottery(numberSet);
    }

    public int score(Lottery lottery) {
        return (int) numberSet.stream()
                .filter(lottery.numberSet::contains)
                .count();
    }

    public Stream<LotteryNumber> stream() {
        return numberSet.stream();
    }
}
