package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    private static final Random RANDOM = new Random();

    public static List<LottoNumber> generate() {
        Set<LottoNumber> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(LottoNumber.valueOf(RANDOM.nextInt(45) + 1));
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(set);
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}

