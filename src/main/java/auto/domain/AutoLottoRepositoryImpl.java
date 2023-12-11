package auto.domain;

import auto.infrastructure.AutoLottoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoRepositoryImpl implements AutoLottoRepository {
    private final static int LOTTERY_MIN_NUMBER = 1;
    private final static int LOTTERY_MAX_NUMBER = 45;
    private static List<Integer> numbers = new ArrayList<>();

    static {
        numbers = IntStream.range(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER + 1)
                           .boxed()
                           .collect(Collectors.toList());
    }

    @Override
    public List<List<Integer>> createLottoNumbersList(int lotteryCount) {
        return IntStream.range(0, lotteryCount)
                        .mapToObj(i -> createLottoNumbers())
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<Integer> createLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
