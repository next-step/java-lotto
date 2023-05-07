package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoCreationStrategy implements LottoCreationStrategy {

    private static final int LOTTO_LENGTH_UPPER_BOUND = 6;
    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 46;
    private static final List<Integer> candidateNumbers = IntStream.range(START_NUMBER, LIMIT_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public List<Lotto> createLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        shuffleCandidateNumbers();
        return new Lotto(findSixLengthAndSortedLotto());
    }

    private List<Integer> findSixLengthAndSortedLotto() {
        return candidateNumbers.stream().limit(LOTTO_LENGTH_UPPER_BOUND).sorted().collect(Collectors.toList());
    }

    private void shuffleCandidateNumbers() {
        Collections.shuffle(candidateNumbers);
    }
}