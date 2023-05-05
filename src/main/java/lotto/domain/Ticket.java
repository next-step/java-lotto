package lotto.domain;

import lotto.exception.NotKindOfLottoNumberException;
import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<LottoNumber> numbers;

    public Ticket(String stringNumbers) {
        Set<LottoNumber> lottoNumbers = parseToNumbers(stringNumbers);
        this.validateTicketNumberCount(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public Ticket(Set<LottoNumber> issueNumbers) {
        this.validateTicketNumberCount(issueNumbers);
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
        String[] splintedStringNumbers = stringNumbers.split(", ");
        validateStringNumbers(splintedStringNumbers);
        Set<LottoNumber> numbers = new HashSet<>();
        for (String number : splintedStringNumbers) {
            numbers.add(LottoNumber.of(Integer.parseInt(number)));
        }
        validateTicketNumberCount(numbers);
        return numbers;
    }

    private void validateStringNumbers(String[] splintedStringNumbers) {
        if (splintedStringNumbers.length != 6) {
            throw new TicketNumbersCountException();
        }
        for (String numberCandidate : splintedStringNumbers) {
            validateNumericString(numberCandidate);
        }
    }

    private void validateNumericString(String numberCandidate) {
        for (char c : numberCandidate.toCharArray()) {
            validateNumericChar(c);
        }
    }

    private void validateNumericChar(char c) {
        if (!('0' <= c && c <= '9')) {
            throw new NotKindOfLottoNumberException(c);
        }
    }

    private void validateTicketNumberCount(Set<LottoNumber> lottoNumbers) {
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
