package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<LottoNumber> numbers;

    public Ticket(String stringNumbers) {
        Set<LottoNumber> lottoNumbers = parseToNumbers(stringNumbers);
        this.validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public Ticket(Set<LottoNumber> issueNumbers) {
        this.validate(issueNumbers);
        this.numbers = issueNumbers;
    }

    public static Ticket of(Set<Integer> integers) {
        return new Ticket(toLottoNumbers(integers));
    }

    private static Set<LottoNumber> toLottoNumbers(Set<Integer> numbers) {
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

    private Set<LottoNumber> parseToNumbers(String stringNumbers) {
        Set<LottoNumber> numbers = new HashSet<>();
        for (String number : stringNumbers.split(", ")) {
            numbers.add(LottoNumber.of(Integer.parseInt(number)));
        }
        validate(numbers);
        return numbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
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

    public Boolean includeNumber(LottoNumber bonusLottoNumber) {
        return this.numbers.contains(bonusLottoNumber);
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .map(number -> Integer.toString(number.getLottoNumber()))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
