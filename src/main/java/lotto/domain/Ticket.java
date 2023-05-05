package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<LottoNumber> numbers;

    public Ticket(String stringNumbers) {
        this.numbers = parseToLottoNumbers(parseToNumbers(stringNumbers));
        validate();
    }

    public Ticket(Set<LottoNumber> issueNumbers) {
        this.numbers = issueNumbers;
        validate();
    }

    public static Ticket of (Set<Integer> integers) {

        Ticket ticket = new Ticket(parseToLottoNumbers(integers));
        ticket.validate();
        return ticket;
    }

    private static Set<LottoNumber> parseToLottoNumbers(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer integer : numbers) {
            lottoNumbers.add(LottoNumber.of(integer));
        }
        return lottoNumbers;
    }

    public static Ticket auto() {
        Set<LottoNumber> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(LottoNumber.any());
        }
        return new Ticket(numbers);
    }

    private Set<Integer> parseToNumbers(String stringNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (String number : stringNumbers.split(", ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate() {
        if (this.numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public int countMatchNumbers(Ticket otherTicket) {
        Set<LottoNumber> copyThisNumbers = new HashSet<>(this.numbers);
        copyThisNumbers.addAll(otherTicket.numbers);
        return overlapCount(copyThisNumbers);
    }

    private int overlapCount(Set<LottoNumber> copyThisNumbers) {
        return 12 - copyThisNumbers.size();
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .map(number -> Integer.toString(number.getLottoNumber()))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Boolean includeNumber(LottoNumber bonusLottoNumber) {
        return this.numbers.contains(bonusLottoNumber);
    }
}
