package lotto.domain;

import lotto.util.NumberUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Number> lottoNumbers;
    private static final int REPEAT = 6;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<Number>();

        while (lottoNumbers.size() != REPEAT) {
            Number number = new Number(NumberUtil.randomNum());
            validAddNumber(number);
        }

        sort();
    }

    private void validAddNumber(Number number) {
        if (!isContains(number.getNumber())) {
            lottoNumbers.add(number);
        }
    }

    public LottoNumbers(List<Integer> integerNumbers) {
        lottoNumbers = new ArrayList<Number>();

        for (int number : integerNumbers) {
            Number passiveNumber = new Number(number);
            isContainsError(passiveNumber);
            lottoNumbers.add(passiveNumber);
        }

        sort();
    }

    private void addNumber(Number number) {
        isContainsError(number);
        lottoNumbers.add(number);
    }

    private void isContainsError(Number insertNum) {
        if (isContains(insertNum.getNumber())) {
            throw new IllegalArgumentException("중복된 데이터가 존재합니다.");
        }
    }

    private void sort() {
        Collections.sort(this.lottoNumbers);
    }

    public boolean isContains(int number) {
        return this.lottoNumbers.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList())
                .contains(number);
    }

    public List<Number> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
