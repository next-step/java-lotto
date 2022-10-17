package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private final List<Integer> lottoNumberRange = new ArrayList<>();

    public LottoNumberGenerator() {
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(this.lottoNumberRange);
        return lottoNumberRange.stream()
                .limit(LottoUtil.LOTTO_NUMBERS)
                .collect(Collectors.toList());
    }
}
