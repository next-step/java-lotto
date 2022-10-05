package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy{

    private final int NUMBER_MIN_BOUND = 1;
    private final int NUMBER_MAX_BOUND = 46;
    private final int FIRST_INDEX = 0;
    private final int LAST_INDEX = 6;
    @Override
    public List<Integer> generateNumbers() {

        List<Integer> collect = IntStream.range(NUMBER_MIN_BOUND, NUMBER_MAX_BOUND)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        Collections.shuffle(collect);
        List<Integer> lottoNumbers = collect.subList(FIRST_INDEX, LAST_INDEX);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
