package lotto.domain.test;

import lotto.domain.Lotto;
import lotto.domain.LottoCreationStrategy;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForceLottoCreationStrategy implements LottoCreationStrategy {

    private static final int LOTTO_LENGTH_UPPER_BOUND = 6;
    private static final int START_NUMBER = 1;
    private static final int LIMIT_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS = generateLottoNumbers();

    private static List<LottoNumber> generateLottoNumbers() {
        return IntStream.rangeClosed(START_NUMBER, LIMIT_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Lotto> createLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(findSixLengthLotto());
    }

    private TreeSet<LottoNumber> findSixLengthLotto() {
        return LOTTO_NUMBERS.stream()
                .map(LottoNumber::getNumber)
                .limit(LOTTO_LENGTH_UPPER_BOUND)
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
