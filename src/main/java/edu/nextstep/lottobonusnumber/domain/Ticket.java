package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.numbersmaker.NumbersMaker;

import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket madeBy(NumbersMaker numbersMaker) {
        return new Ticket(numbersMaker.create());
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    public int countMatchingNumbers(Ticket winningTicket) {
        return 0;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
