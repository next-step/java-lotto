package lotto.domain;

import lotto.dto.NumberData;
import lotto.dto.TicketData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoTicket {
    public static final int TICKET_LENGTH = 6;

    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        if (!isProperNumberCnt(numbers) || hasDuplicateNumber(numbers)) {
            throw new RuntimeException();
        }

        this.numbers = numbers;
    }

    private boolean isProperNumberCnt(List<LottoNumber> numbers) {
        return numbers.size() == TICKET_LENGTH;
    }

    private boolean hasDuplicateNumber(List<LottoNumber> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public int getMatchedCnt(LottoTicket other) {
        return numbers.stream().filter(
            other.numbers::contains
        ).collect(
            Collectors.toList()
        ).size();
    }

    public boolean includeNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public TicketData getTicketData() {
        List<NumberData> numbersData = new ArrayList<>();
        for (LottoNumber number : numbers) {
            numbersData.add(
                number.getNumberData()
            );
        }
        return new TicketData(numbersData);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
