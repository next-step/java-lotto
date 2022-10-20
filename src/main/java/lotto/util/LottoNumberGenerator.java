package lotto.util;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private final List<Number> lottoNumberRange = new ArrayList<>();

    public LottoNumberGenerator() {
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(new Number(i));
        }
    }

    public List<Number> getLottoNumbers() {
        Collections.shuffle(this.lottoNumberRange);
        return lottoNumberRange.stream()
                .limit(LottoUtil.LOTTO_NUMBERS)
                .collect(Collectors.toList());
    }
}
