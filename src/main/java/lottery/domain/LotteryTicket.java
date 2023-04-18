package lottery.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static final int LOTTERY_TICKET_SIZE = 6;

    private final List<LotteryNumber> ticketNumbers;

    public LotteryTicket(List<LotteryNumber> ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
        if (!isValidSize()) {
            throw new IllegalArgumentException("로또 티켓은 6개의 로또 번호를 가지고 있어야 합니다.");
        }
    }

    public int numberCount() {
        return ticketNumbers.size();
    }

    private boolean isValidSize() {
        return ticketNumbers.size() == LOTTERY_TICKET_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(ticketNumbers, that.ticketNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumbers);
    }

    public int match(LotteryTicket ticket) {
        return ticketNumbers.stream()
                .filter(ticket::contains)
                .mapToInt(number -> 1)
                .sum();
    }

    private boolean contains(LotteryNumber number) {
        return ticketNumbers.contains(number);
    }

    @Override
    public String toString() {
        return addBrackets(
                ticketNumbers.stream()
                        .map(LotteryNumber::getNumber)
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
        );
    }

    private String addBrackets(String str) {
        return "[" + str + "]";
    }
}
