package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomSelectRule implements SelectRule {
    @Override
    public boolean isSelectable() {
        return true;
    }

    public LottoNumbers select() {
        List<Integer> availableNumbers = findAvailableNumbers(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER);
        Collections.shuffle(availableNumbers);
        List<Integer> lottoNumbers = availableNumbers.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT);
        return LottoNumbers.create(lottoNumbers);
    }

    private List<Integer> findAvailableNumbers(int min, int max) {
        return IntStream.range(min, max).boxed().collect(Collectors.toList());
    }
}
