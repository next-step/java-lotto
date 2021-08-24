package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;
import edu.nextstep.lottobonusnumber.domain.numbersmaker.NumbersMaker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLengthOfNumbers(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    private void validateOutOfRange(List<Integer> numbers) {
        if (numbers.get(0) < MIN_NUMBER || numbers.get(numbers.size()-1) > MAX_NUMBER) {
            throw new NumbersIllegalArgumentException("지정 가능 숫자 범위 초과. 범위 : " + MIN_NUMBER + " ~ " + MAX_NUMBER);
        }
    }

    private void validateLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() != LENGTH_OF_NUMBERS) {
            throw new NumbersIllegalArgumentException("입력 숫자 개수 미달 or 초과. 지정 개수 : " + LENGTH_OF_NUMBERS);
        }
    }

    public static Ticket madeBy(NumbersMaker numbersMaker) {
        List<Integer> numbers = numbersMaker.create();
        return new Ticket(numbers);
    }

    public int countMatchingNumbers(Ticket winningTicket) {
        return (int) winningTicket.stream()
                .filter(numbers::contains)
                .count();
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isEqualTo);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
