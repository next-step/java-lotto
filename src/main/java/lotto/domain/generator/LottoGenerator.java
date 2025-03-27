package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final List<LottoNumber> LOTTO_NUMBER_CACHE = LottoNumber.generateLottoNumberList();

    private LottoGenerator() {
    }

    public static List<Lotto> generateLottoListByAmount(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < calculateLottoCount(amount); i++) {
            lottoList.add(generateLotto());
        }

        return lottoList;
    }

    public static int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public static Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBER_CACHE);

        List<LottoNumber> lottoNumbers = LOTTO_NUMBER_CACHE.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

}
