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

    public Map<Integer, Integer> calculateSameNumberCounts(LottoNumber lottoNumber) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (LottoNumber number : lottoNumbers) {
            calculateOneStage(lottoNumber, counts, number);
        }
        return counts;
    }

    private void calculateOneStage(LottoNumber lottoNumber,
                                   Map<Integer, Integer> counts,
                                   LottoNumber number) {
        int count = number.calculateSameNumberCount(lottoNumber);
        if (counts.containsKey(count)) {
            counts.put(count, counts.get(count) + 1);
            return;
        }
        counts.put(count, 1);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
