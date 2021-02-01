package lotto.domain;

import lotto.dto.TicketData;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class LottoTicket {
    public static final int TICKET_LENGTH = 6;
    private static final String TICKET_LENGTH_ERROR_MSG = String.format(
        "로또 1장은 %d개 번호 여야 합니다.", TICKET_LENGTH
    );
    private static final String TICKET_DUPLICATE_NUMBER_MSG = "로또 번호는 서로 다른 수여야 합니다.";

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        if (!isProperNumberCnt(numbers)) {
            throw new RuntimeException(TICKET_LENGTH_ERROR_MSG);
        }

        if (hasDuplicateNumber(numbers)) {
            throw new RuntimeException(TICKET_DUPLICATE_NUMBER_MSG);
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
        return (int) numbers.stream().filter(
            other.numbers::contains
        ).count();
    }

    public boolean includeNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public TicketData getTicketData() {
        return new TicketData(
            numbers.stream().map(
                LottoNumber::getNumberData
            ).collect(
                Collectors.toList()
            )
        );
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
