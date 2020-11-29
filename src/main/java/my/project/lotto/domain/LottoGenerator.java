package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created : 2020-11-27 오후 2:16
 * Developer : Seo
 */
public class LottoGenerator {
    private static final List<Integer> numbers = new ArrayList<>();

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    static {
        for (int i = MIN_NUMBER; i < MAX_NUMBER + 1; i++) {
            numbers.add(i);
        }
    }

    public static Lotto generate() {
        Collections.shuffle(numbers);
        List<LottoNumber> lotto = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
            lotto.add(new LottoNumber(numbers.get(i)));
        }
        return new Lotto(lotto);
    }

    private LottoGenerator() {
    }
}
