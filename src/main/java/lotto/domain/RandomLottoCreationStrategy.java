package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbersGenerator.*;

public class RandomLottoCreationStrategy implements LottoCreationStrategy {

    private static final int LOTTO_LENGTH_UPPER_BOUND = 6;

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
        return getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .limit(LOTTO_LENGTH_UPPER_BOUND)
                .sorted()
                .collect(Collectors.toList());
    }

    private void shuffleCandidateNumbers() {
        Collections.shuffle(getLottoNumbers());
    }
}
