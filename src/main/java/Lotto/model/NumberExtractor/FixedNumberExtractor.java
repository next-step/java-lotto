package Lotto.model.NumberExtractor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedNumberExtractor implements NumberExtractor{
    private int[] numbers;

    public FixedNumberExtractor(int[] fixedNumbers){
        numbers = fixedNumbers;
    }

    @Override
    public List<Integer> extract(int size, int min, int max) {
        return Arrays.stream(this.numbers)
                .boxed()
                .collect(Collectors.toList());
    }
}
