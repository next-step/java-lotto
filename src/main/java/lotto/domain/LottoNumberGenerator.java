package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {

    private Random random = new Random();

    public List<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(random.nextInt(45) + 1));
        }
        return lottoNumbers;
    }
}

