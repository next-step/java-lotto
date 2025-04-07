package Lotto.model.NumberExtractor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberExtractor implements NumberExtractor {
    private List<Integer> numbers;

    public FixedNumberExtractor(int[] fixedNumbers) {
        this.numbers = Arrays.stream(fixedNumbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public FixedNumberExtractor(List<Integer> fixedNumbers) {
        this.numbers = fixedNumbers;
    }

    @Override
    public List<Integer> extract(int size) {
        return new ArrayList<>(this.numbers);
    }
}
