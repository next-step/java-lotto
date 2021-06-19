package lottoAuto.model;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto createLotto() {
        Collections.shuffle(LottoNumbers.lottoNumbers);
        Set<LottoNumber> lotto = LottoNumbers.lottoNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(lottoNumber -> new LottoNumber(lottoNumber))
                .collect(Collectors.toSet());

        return new Lotto(lotto);
    }
}
