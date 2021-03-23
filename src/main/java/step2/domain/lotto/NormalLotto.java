package step2.domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NormalLotto {

    public static final int PRICE = 1000;
    protected static final int UPPER_BOUND = 45;
    protected static final int COUNT = 6;

    private final List<Integer> numbers;

    public NormalLotto(List<Integer> numbers) {
        if (!valid(numbers)) throw new IllegalArgumentException();
        this.numbers = numbers;
    }

    public NormalLotto() {
        this(NormalLotto.numbers());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static List<Integer> numbers() {
        return IntStream.rangeClosed(1, UPPER_BOUND)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), NormalLotto::shuffleList))
                .subList(0, COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<Integer> shuffleList(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    public boolean valid(List<Integer> numbers) {
        return sizeSix(numbers) && inBoundary(numbers) && unique(numbers);
    }

    private boolean sizeSix(List<Integer> numbers){
        return numbers.size()==COUNT;
    }

    private boolean inBoundary(List<Integer> numbers) {
        boolean validFlag = true;
        for (Integer number : numbers) {
            validFlag &= (number >= 1 && number <= UPPER_BOUND);
        }
        return validFlag;
    }

    private boolean unique(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == COUNT;
    }

    @Override
    public String toString() {
        return "" + numbers;
    }
}
