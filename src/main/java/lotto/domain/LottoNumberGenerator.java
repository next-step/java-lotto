package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    public static final LottoNumber[] cache;
    private static final Random RANDOM = new Random();
    private static final int START_INDEX = 0;

    static {
        cache = new LottoNumber[LottoNumber.MAX];
        for (int i = START_INDEX; i < LottoNumber.MAX; i++) {
            cache[i] = LottoNumber.valueOf(i + LottoNumber.MIN);
        }
    }

    private LottoNumberGenerator() {}

    public static LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = generateUnRedundantNumbers();
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    static List<LottoNumber> generateUnRedundantNumbers() {
        Set<LottoNumber> set = new HashSet<>();
        while (set.size() < LottoNumbers.LOTTO_NUMBER_MAX_SIZE) {
            set.add(cache[random() - LottoNumber.MIN]);
        }
        return new ArrayList<>(set);
    }

    private static int random() {
        return RANDOM.nextInt(LottoNumber.MAX) + LottoNumber.MIN;
    }
}

