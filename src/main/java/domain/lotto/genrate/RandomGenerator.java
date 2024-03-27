package domain.lotto.genrate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LottoGenerator {
    private final List<Integer> numberList;
    private final static int MINIMUM_LOTTO_NUMBER_RANGE = 0;
    private final static int MAX_LOTTO_NUMBER_RANGE = 6;
    private final int size;

    public RandomGenerator(int size) {
        this.size = size;
    }

    {
        numberList = initLottoNumberRange();
    }


    private List<Integer> initLottoNumberRange() {
        return IntStream.range(1, 45).boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> create() {
        shuffle();
        return sortedUnmodifiableListBy(createLottoBoundryIntegerList());
    }

    @Override
    public int getSize() {
        return size;
    }

    private List<Integer> sortedUnmodifiableListBy(List<Integer> integerList) {
        return integerList
                .stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Integer> createLottoBoundryIntegerList() {
        return numberList.subList(MINIMUM_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void shuffle() {
        Collections.shuffle(numberList);
    }
}
