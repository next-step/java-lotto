package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_COUNT = 6;
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        initLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private void initLottoNumbers() {
        Random random = new Random();

        int count = 0;
        while (true) {
            if (count == LOTTO_COUNT) break;
            int randomValue = random.nextInt(46);
            if (lottoNumbers.contains(randomValue)) continue;
            lottoNumbers.add(randomValue);
            count++;
        }

        Collections.shuffle(lottoNumbers);
    }

    public boolean isBonusBallInLotto(int bonusBall) {
        return this.lottoNumbers.contains(bonusBall);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
