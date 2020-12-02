package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created : 2020-11-27 오후 2:16
 * Developer : Seo
 */
public class LottoGenerator {
    private static final List<LottoNumber> numbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i < LottoNumber.LOTTO_MAX_NUMBER + 1; i++) {
            numbers.add(LottoNumber.valueOf(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(numbers);
        List<LottoNumber> lotto = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
            lotto.add(numbers.get(i));
        }
        return new Lotto(lotto);
    }

    private LottoGenerator() {
    }
}