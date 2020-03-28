package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    public static List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = removeDuplicateNumbers();
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static List<LottoNumber> removeDuplicateNumbers() {
        Set<LottoNumber> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(LottoNumber.valueOf(random()));
        }
        return new ArrayList<>(set);
    }

    private static int random() {
        return RANDOM.nextInt(LottoNumber.MAX) + LottoNumber.MIN;
    }
}

