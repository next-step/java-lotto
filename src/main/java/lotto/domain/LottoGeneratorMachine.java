package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorMachine implements GeneratorStrategy {
    @Override
    public Lotto generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(0, 6));
    }
}
