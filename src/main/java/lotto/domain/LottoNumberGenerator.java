package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    public static LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = generateUnRedundantNumbers();
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> generateUnRedundantNumbers() {
        Set<LottoNumber> set = new HashSet<>();
        while (set.size() < LottoNumbers.LOTTO_NUMBER_MAX_SIZE) {
            set.add(LottoNumberCache.cache[random() - LottoNumber.MIN]);
        }
        return new ArrayList<>(set);
    }

    private static int random() {
        return RANDOM.nextInt(LottoNumber.MAX) + LottoNumber.MIN;
    }

    private static class LottoNumberCache {
        private static final int START_INDEX = 0;
        static final LottoNumber[] cache = new LottoNumber[LottoNumber.MAX];

        static {
            for (int i = START_INDEX; i < LottoNumber.MAX; i++) {
                cache[i] = LottoNumber.valueOf(i + LottoNumber.MIN);
            }
        }

        private LottoNumberCache() {}
    }
}

