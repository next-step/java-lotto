package step4.model;

import step4.enumeration.LottoRank;

import java.util.Arrays;
import java.util.List;

import static step4.enumeration.LottoRank.SECOND;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoRank getLottoRank(List<Integer> winNumbers, int bonusNumber) {
        int count = (int) winNumbers.stream()
                .filter(lottoNumbers::isContain)
                .count();

        if (LottoRank.isSecondRank(count, bonusNumber, this.lottoNumbers.getNumbers())) {
            return SECOND;
        }

        return LottoRank.getRank(count);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.lottoNumbers.getNumbers().toArray());
    }
}
