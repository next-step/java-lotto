package lotto.domain.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutomaticStrategy extends LottoStrategy {
    @Override
    public List<LottoNumber> lottoNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>();

        final List<Integer> copy = new ArrayList<>(LOTTO_NUMBER_LIST);
        Collections.shuffle(copy);

        final List<Integer> result = copy.subList(0, 6);
        Collections.sort(result);

        for (Integer number : result) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }
}
