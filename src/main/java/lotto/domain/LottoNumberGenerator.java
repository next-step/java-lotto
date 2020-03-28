package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {

    private Random random = new Random();

    public List<LottoNumber> generate() {
        Set<LottoNumber> set = new HashSet<>();
        LottoNumber lottoNumber;
        while (set.size() < 6) {
            lottoNumber = new LottoNumber(random.nextInt(45) + 1);
            set.add(lottoNumber);
        }
        List<LottoNumber> lottoNumbers = new ArrayList<>(set);
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}

