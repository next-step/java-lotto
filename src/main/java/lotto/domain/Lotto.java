package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_BOUND = 46;
    private List<LottoNo> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        initLottoNumbers();
    }

    public Lotto(String[] lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        for (String number : lottoNumbers) {
            this.lottoNumbers.add(new LottoNo(number));
        }
    }

    private void initLottoNumbers() {
        Random random = new Random();

        int count = 0;
        while (true) {
            if (count == LOTTO_COUNT) break;
            int randomValue = random.nextInt(LOTTO_BOUND);
            if (lottoNumbers.contains(randomValue)) continue;
            lottoNumbers.add(new LottoNo(randomValue));
            count++;
        }

        Collections.shuffle(lottoNumbers);
    }

    public boolean isBonusBallInLotto(int bonusBall) {
        return this.contains(bonusBall);
    }

    public List<LottoNo> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean contains(Integer number) {
        for (LottoNo lottoNo : this.lottoNumbers) {
            if (lottoNo.equals(number))
                return true;
        }
        return false;
    }
}
