package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        List<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            temp.add(i);
        }

        Collections.shuffle(temp);
        this.lottoNumbers = temp.subList(0, 6);
        sort();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean isContains(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
