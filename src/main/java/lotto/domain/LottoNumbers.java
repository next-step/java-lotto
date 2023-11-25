package lotto.domain;

import lotto.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Number> lottoNumbers;
    private static final int REPEAT = 6;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<Number>();

        for (int i = 0; i <REPEAT; i++) {
            lottoNumbers.add(new Number(Util.randomNum()));
        }
        sort();
    }

    public LottoNumbers(List<Integer> integerNumbers) {
        lottoNumbers = new ArrayList<Number>();

        for (int number : integerNumbers) {
            lottoNumbers.add(new Number(number));
        }

        sort();
    }


    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean isContains(int winningNumber) {
        return this.lottoNumbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList())
                .contains(winningNumber);
    }

    public List<Number> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
