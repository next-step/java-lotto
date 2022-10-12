package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    List<Integer> lottoNumberRange = new ArrayList<>();

    public LottoNumberGenerator() {
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(i);
        }
    }

    public List<Integer> shuffleLottoNumbers() {
        Collections.shuffle(this.lottoNumberRange);
        return this.lottoNumberRange;
    }
}
