package lotto.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoGenerator {

    public static Lotto generate() {
        Random random = new Random();
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            int number = random.nextInt(45) + 1;
            lottoNumbers.add(new LottoNumber(number));
        }
        return new Lotto(lottoNumbers);
    }
}
