package lotto.domain;

import lotto.dto.NumberData;
import lotto.dto.TicketData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoTicket {
    public static final int TICKET_LENGTH = 6;

    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        if (numbers.size() != TICKET_LENGTH) {
            throw new RuntimeException();
        }
        this.numbers = numbers;
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

    public TicketData getLottoTicketDTO() {
        List<NumberData> numbersDTO = new ArrayList<>();
        for (LottoNumber number : numbers) {
            numbersDTO.add(number.getNumberData());
        }
        return new TicketData(numbersDTO);
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
