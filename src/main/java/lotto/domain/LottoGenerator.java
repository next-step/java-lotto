package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;

    public LottoGenerator() {
    }

    public Lotto generateLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() != LOTTO_SIZE) {
            lottoNumbers.add(LottoNumber.generateLottoNumber());
        }
        return new Lotto(lottoNumbers);
    }
}
