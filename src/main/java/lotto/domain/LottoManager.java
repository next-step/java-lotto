package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final LottoNumbers lottoNumbers;

    public LottoManager() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<Lotto> createLottos(String value) {
        int lottoCount = Integer.parseInt(value) / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoNumbers.randomLottoNumbers()));
        }

        return lottos;
    }
}
