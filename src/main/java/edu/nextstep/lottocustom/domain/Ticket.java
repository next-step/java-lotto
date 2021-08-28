package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.NumbersMaker;
import edu.nextstep.lottocustom.exception.NumbersIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    private Ticket(List<LottoNumber> numbers) {
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
