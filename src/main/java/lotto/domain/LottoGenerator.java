package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> CANDIDATE_POOL =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());

    public List<Lotto> generate(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> candidatePoolCopy = new ArrayList<>(CANDIDATE_POOL);
            Collections.shuffle(candidatePoolCopy);
            List<Integer> numbers = new ArrayList<>(candidatePoolCopy.subList(0, 6));
            Collections.sort(numbers);
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public List<Lotto> generate(List<List<Integer>> numbers) {
        List<Lotto> lottoList = new ArrayList<>();
        for (List<Integer> number : numbers) {
            lottoList.add(new Lotto(number));
        }
        return lottoList;
    }

}