package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers implements Numbers {
    private static final int BOUND = 45;

    @Override
    public List<LottoNumber> generateNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(generateRandomInt()));
        }
        return lottoNumbers;
    }

    public int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(BOUND) + 1;
    }
}
