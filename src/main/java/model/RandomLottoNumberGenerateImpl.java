package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerateImpl implements LottoNumberGenerate {
    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int j = Lotto.MIN_LOTTO_NUMBER; j <= Lotto.MAX_LOTTO_NUMBER; j++) {
            numbers.add(j);
        }
        Collections.shuffle(numbers);
        return numbers.subList(LOTTO_START_INDEX, LOTTO_END_INDEX);
    }

    @Override
    public List<List<Integer>> multiGenerate(int start, int end) {
        return IntStream.range(start, end)
                .mapToObj(it -> generate())
                .collect(Collectors.toList());
    }
}
