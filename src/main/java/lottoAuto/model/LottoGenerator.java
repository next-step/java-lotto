package lottoAuto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public LottoGenerator() {
        LottoNumbers.addLottoNumber();
    }

    public Lotto createLotto() {
        Collections.shuffle(LottoNumbers.lottoNumbers);
        List<Integer> lotto = LottoNumbers.lottoNumbers.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
        Collections.sort(lotto);

        return new Lotto(lotto);
    }
}
