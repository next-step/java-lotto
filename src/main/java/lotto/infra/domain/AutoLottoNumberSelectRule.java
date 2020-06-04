package lotto.infra.domain;

import lotto.domain.LottoNumberSelectRule;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AutoLottoNumberSelectRule implements LottoNumberSelectRule {

    @Override
    public LottoNumbers select() {
        Collections.shuffle(LottoNumbers.CANDIDATE_NUMBERS);
        Set<Integer> numbers = new HashSet<>(LottoNumbers.CANDIDATE_NUMBERS.subList(0, LottoNumbers.COUNT_OF_NUMBERS));
        return new LottoNumbers(numbers);
    }
}
