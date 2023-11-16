package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers = new ArrayList<>();

    private Lotto() {
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        Lotto lotto = new Lotto();
        lotto.lottoNumbers = lottoNumbers;
        return lotto;
    }

    public List<Integer> getLottoNumbers() {
        sortLottoNumbers();
        return this.lottoNumbers;
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumbers);
    }


    public int getMatchCount(List<Integer> lastWeekLottoNumbers) {
        // TODO lottoNumbers 와 lastWeekLottoNumbers 를 비교하여 일치하는 갯수를 구한다.
        int matchCount = 0;
        for (int i = 0; i < lastWeekLottoNumbers.size(); i++) {
            matchCount = getMatchCount(lastWeekLottoNumbers, i, matchCount);
        }
        return matchCount;

    }

    private int getMatchCount(List<Integer> lastWeekLottoNumbers, int idx, int matchCount) {
        if (lottoNumbers.contains(lastWeekLottoNumbers.get(idx))) {
            matchCount++;
        }
        return matchCount;
    }
}
