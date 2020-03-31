package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    private LottoNumberGenerator() {}

    public static LottoNumbers generate() {
        List<LottoNumber> lottoNumbers = generateUnRedundantNumbers();
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers);
    }

    private static List<LottoNumber> generateUnRedundantNumbers() {
        Set<LottoNumber> set = new HashSet<>();
        while (set.size() < LottoNumbers.LOTTO_NUMBER_MAX_SIZE) {
            set.add(LottoNumber.valueOf(random()));
        }
        return new ArrayList<>(set);
    }

    private static int random() {
        return RANDOM.nextInt(LottoNumber.MAX) + LottoNumber.MIN;
    }
}

