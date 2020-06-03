package step2.domain;

import static step2.domain.LottoGenerator.LOTTO_FIRST_NUMBER;
import static step2.domain.LottoGenerator.LOTTO_LAST_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerableStrategy implements GenerableStrategy {

    private List<Integer> lottoBaseNumbers;

    public RandomGenerableStrategy() {
        lottoBaseNumbers = makeSequentialNumbers(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER);
    }

    @Override
    public List<Integer> generate(int count) {
        List<Integer> copiedLottoBaseNumbers = new ArrayList<>();
        copiedLottoBaseNumbers.addAll(lottoBaseNumbers);
        return getSequentialShuffledNumbers(copiedLottoBaseNumbers, count);
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
