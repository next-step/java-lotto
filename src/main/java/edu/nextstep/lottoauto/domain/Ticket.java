package edu.nextstep.lottoauto.domain;

import edu.nextstep.lottoauto.exception.NumbersIllegalArgumentException;
import edu.nextstep.lottoauto.domain.ticketmaker.NumbersMaker;

import java.util.Collections;
import java.util.List;

public class Ticket {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLengthOfNumbers(numbers);
        validateOutOfRange(numbers);
        this.numbers = numbers;
    }

    public static Ticket madeBy(NumbersMaker numbersMaker) {
        return new Ticket(numbersMaker.create());
    }

    public int countMatchingNumbers(Ticket winningTicket) {
        return (int) numbers.stream()
                .filter(winningTicket.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
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
}
