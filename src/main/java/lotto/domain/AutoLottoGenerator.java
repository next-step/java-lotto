package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(generateAutoNumbers());
    }

    private Set<LottoNumber> generateAutoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumber.findLottoNumberValues();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .collect(Collectors.toSet());
    }
}
