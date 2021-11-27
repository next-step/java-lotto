package lotto.model;

import common.model.Number;
import lotto.application.Constant;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    protected final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        lengthValidation(lottoNumbers);
        duplicateValidation(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        sort();
    }

    private void lengthValidation(List<LottoNumber> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_MESSAGE_LENGTH_VALIDATION);
        }
    }

    private void duplicateValidation(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != Constant.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(Constant.EXCEPTION_MESSAGE_DUPLICATE_VALIDATION);
        }
    }

    private void sort() {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
    }

    public void match(LottoNumber lottoNumber, Number count) {
        if (contains(lottoNumber)) {
            count.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "[" + this.lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(", ")) + "]";

    }
}