package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoCreationStrategy implements LottoCreationStrategy {

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
        shuffleLottoNumbers();
        return new Lotto(new LinkedHashSet<>(findSixLengthLotto()));
    }

    private List<LottoNumber> findSixLengthLotto() {
        return LOTTO_NUMBERS.stream()
                .map(LottoNumber::getNumber)
                .limit(LOTTO_LENGTH_UPPER_BOUND)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void shuffleLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
    }
}
