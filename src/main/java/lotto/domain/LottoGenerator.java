package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS_CACHE = new ArrayList<>();

    static {
        for (int i = LottoNumber.MINIMUM_LOTTO_NUMBER; i <= LottoNumber.MAXIMUM_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS_CACHE.add(new LottoNumber(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(LOTTO_NUMBERS_CACHE);
        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS_CACHE.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto generate(String numbers) {
        String[] splitNumbers = numbers.split(", ");
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
        return new Lotto(lottoNumbers);
    }

    public static Lottos generate(long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generate());
        }
        return new Lottos(lottos);
    }

    public static Lottos generate(Money receivedMoney) {
        return generate((long) receivedMoney.divide(Lotto.LOTTO_AMOUNT));
    }
}
