package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private List<Integer> lottoNumbers;

    public LottoNumbers(int minLottoNumber, int maxLottoNumber) {
        List<Integer> shuffledNumbers = IntStream.rangeClosed(minLottoNumber, maxLottoNumber).boxed().collect(Collectors.toList());
        Collections.shuffle(shuffledNumbers);
        this.lottoNumbers = shuffledNumbers.subList(0, 6);
        Collections.sort(this.lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int matchCount(List<Integer> lastWeekLottoNumbers) {
        int matchCount = 0;
        for (int i = 0; i < lastWeekLottoNumbers.size(); i++) {
            matchCount = calculateMatchCount(lastWeekLottoNumbers, i, matchCount);
        }
        return matchCount;
    }

    private int calculateMatchCount(List<Integer> lastWeekLottoNumbers, int idx, int matchCount) {
        if (lottoNumbers.contains(lastWeekLottoNumbers.get(idx))) {
            matchCount++;
        }
        return matchCount;
    }
}
