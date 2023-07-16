package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomCandidateStrategy implements CandidateStrategy {

    private static final List<Integer> numbers =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public List<Integer> generateCandidates() {
        List<Integer> candidates = new ArrayList<>(numbers);
        Collections.shuffle(candidates);
        return candidates;
    }
}
