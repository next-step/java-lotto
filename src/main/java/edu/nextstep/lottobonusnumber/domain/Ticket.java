package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;
import edu.nextstep.lottobonusnumber.domain.numbersmaker.NumbersMaker;

import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    public Ticket(List<LottoNumber> numbers) {
        validateLengthOfNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLengthOfNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LENGTH_OF_NUMBERS) {
            throw new NumbersIllegalArgumentException("입력 숫자 개수 미달 or 초과. 지정 개수 : " + LENGTH_OF_NUMBERS);
        }
    }

    public static Ticket madeBy(NumbersMaker numbersMaker) {
        List<LottoNumber> numbers = numbersMaker.create();
        return new Ticket(numbers);
    }

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
