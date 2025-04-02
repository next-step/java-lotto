package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final Integer LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static List<LottoNumbers> sellLotto(final int price) {
        int lottoCount = price / LOTTO_PRICE;

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumber = LottoMachine.generateLottoNumber();
            lottoNumbersList.add(lottoNumber);
        }

        return lottoNumbersList;
    }
}
