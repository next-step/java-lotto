package lotto.lottogenerator;

import lotto.model.lottonumber.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoNumMaker {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public static List<LottoNumber> makePool() {
        List<LottoNumber> pool = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            pool.add(LottoNumber.of(i));
        }

        return pool;
    }
}
