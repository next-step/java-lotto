package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;

public class LottoGeneratorAutoStrategy implements LottoGeneratorStrategy {
    @Override
    public Set<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.CACHE);
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, Lotto.VALID_SIZE));
    }
}
