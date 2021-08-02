package lotto.domain;

import java.util.*;

public class RandomLottoNumbers implements LottoNumbers {
    private static final int BOUND = 45;
    private static final int SIZE = 6;

    @Override
    public Set<LottoNumber> generateNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while(lottoNumbers.size() < SIZE) {
            lottoNumbers.add(new LottoNumber(generateRandomInt()));
        }
        return lottoNumbers;
    }

    public int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(BOUND) + 1;
    }
}
