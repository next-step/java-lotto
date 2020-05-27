package step2;

import static step2.LottoGenerator.LOTTO_FIRST_NUMBER;
import static step2.LottoGenerator.LOTTO_LAST_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerableStrategy implements GenerableStrategy {

    @Override
    public List<Integer> generate(int count) {
        List<Integer> sequentialNumbers = makeSequentialNumbers(
            LOTTO_FIRST_NUMBER,
            LOTTO_LAST_NUMBER);
        return getSequentialShuffledNumbers(sequentialNumbers, count);
    }

    private List<Integer> makeSequentialNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
            .boxed()
            .collect(Collectors.toList());
    }

    private List<Integer> getSequentialShuffledNumbers(List<Integer> sequentialNumbers, int count) {
        Collections.shuffle(sequentialNumbers);
        sequentialNumbers = sequentialNumbers.subList(0, count);
        Collections.sort(sequentialNumbers);
        return sequentialNumbers;
    }
}
