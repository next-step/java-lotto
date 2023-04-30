package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumbers {
    
    private final List<LottoNumber> lottoNumbers;
    private NumberCreationStrategy strategy;

    public LottoNumbers(List<LottoNumber> lottoNumbers, NumberCreationStrategy strategy) {
        this.lottoNumbers = lottoNumbers;
        this.strategy = strategy;
    }

    public LottoNumbers(int lottoCount, NumberCreationStrategy strategy) {
        this.strategy = strategy;
        this.lottoNumbers = createLottoNumbers(lottoCount);
    }

    private List<LottoNumber> createLottoNumbers(int lottoCount) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            numbers.add(new LottoNumber(strategy));
        }
        return numbers;
    }

    public Map<LottoRank, Integer> calculateSameNumberCounts(LottoNumber lottoNumber, int bonusNumber) {
        Map<LottoRank, Integer> counts = new HashMap<>();
        for (LottoNumber number : lottoNumbers) {
            calculateOneStage(lottoNumber, counts, number, bonusNumber);
        }
        return counts;
    }

    private void calculateOneStage(LottoNumber lottoNumber,
                                   Map<LottoRank, Integer> counts,
                                   LottoNumber number,
                                   int bonusNumber) {
        LottoRank lottoRank = LottoRank.valueOf(
                number.calculateSameNumberCount(lottoNumber),
                number.hasBonusNumber(bonusNumber));
        if (counts.containsKey(lottoRank)) {
            counts.put(lottoRank, counts.get(lottoRank) + 1);
            return;
        }
        counts.put(lottoRank, 1);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
