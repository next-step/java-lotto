package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoRandomNumberGenerator;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new ArrayList<>();
        this.publish();
    }

    private List<Integer> publish() {
        for (int i = 0; i < 6; i++) {
            int randomNumber = LottoRandomNumberGenerator.next();

            while(this.lottoNumbers.contains(randomNumber)) {
                randomNumber = LottoRandomNumberGenerator.next();
            }

            this.lottoNumbers.add(randomNumber);
        }

        return lottoNumbers;
    }

    public int getContainsCount(final List<Integer> winningNumbers) {
        int containsCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (this.lottoNumbers.contains(winningNumber)) {
                containsCount++;
            }
        }

        return containsCount;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
