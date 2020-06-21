package step2.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import step2.util.Utils;

public class RandomGenerableStrategy implements GenerableStrategy {

    @Override
    public List<LottoNumber> generate(int start, int end, int count) {
        List<Integer> generatedNumbers = getSequentialShuffledNumbers(start, end, count);
        return Utils.convertIntegerToLottoNumberList(generatedNumbers);
    }

    private List<Integer> getSequentialShuffledNumbers(int start, int end, int count) {
        List<Integer> sequentialNumbers = Arrays
            .asList(IntStream.rangeClosed(start, end).boxed().toArray(Integer[]::new));
        Collections.shuffle(sequentialNumbers);
        sequentialNumbers = sequentialNumbers.subList(0, count);
        Collections.sort(sequentialNumbers);
        return sequentialNumbers;
    }
}
