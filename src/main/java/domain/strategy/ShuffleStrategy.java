package domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.LottoNumber.MAX_RANGE;
import static domain.LottoNumber.MIN_RANGE;

public class ShuffleStrategy implements LottoNumberStrategy {

    @Override
    public List<Integer> generateNumbers(int count) {
        List<Integer> candidateNumList = this.getCandidateNumList();
        Collections.shuffle(candidateNumList);

        List<Integer> result = candidateNumList.subList(0, count);

        Collections.sort(result);
        return result;
    }

    private List<Integer> getCandidateNumList() {
        return IntStream.rangeClosed(MIN_RANGE, MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());
    }
}
