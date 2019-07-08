package camp.nextstep.edu.lotto.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Lottery implements Iterable<LotteryNumber> {

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
        if (lottery == null) {
            throw new IllegalArgumentException("'lottery' must not be null");
        }
        return (int) numberSet.stream()
                .filter(lottery.numberSet::contains)
                .count();
    }

    public boolean hasBonus(LotteryNumber lotteryNumber) {
        if (lotteryNumber == null) {
            throw new IllegalArgumentException("'lotteryNumber' must not be null");
        }
        return numberSet.contains(lotteryNumber);
    }

    public Stream<LotteryNumber> stream() {
        return numberSet.stream();
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "numberSet=" + numberSet +
                '}';
    }

    @Override
    public Iterator<LotteryNumber> iterator() {
        return numberSet.iterator();
    }

    @Override
    public void forEach(Consumer<? super LotteryNumber> action) {
        numberSet.forEach(action);
    }

    @Override
    public Spliterator<LotteryNumber> spliterator() {
        return numberSet.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return numberSet.equals(lottery.numberSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberSet);
    }
}
