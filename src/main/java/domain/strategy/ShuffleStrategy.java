package domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleStrategy implements LottoNumberStrategy {
    final static int MAX_RANGE = 45;

    @Override
    public List<Integer> generateNumbers(int count) {
        List<Integer> candidateNumList = this.getCandidateNumList();
        Collections.shuffle(candidateNumList);

        List<Integer> result = candidateNumList.subList(0, count);

        Collections.sort(result);
        return result;
    }

    private List<Integer> getCandidateNumList() {
        return IntStream.rangeClosed(1, MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());
    }
}
