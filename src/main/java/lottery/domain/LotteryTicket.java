package lottery.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static final int LOTTERY_TICKET_SIZE = 6;
    public static final int LOTTERY_TICKET_PRICE = 1_000;

    private final List<LotteryNumber> ticketNumbers;

    public LotteryTicket(List<LotteryNumber> ticketNumbers) {
        if (!isValidSize(ticketNumbers.size())) {
            throw new IllegalArgumentException("로또 티켓은 6개의 로또 번호를 가지고 있어야 합니다.");
        }
        this.ticketNumbers = ticketNumbers;
    }

    public static LotteryTicket valueOf(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = numbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        return new LotteryTicket(lotteryNumbers);
    }

    public static boolean isValidSize(int size) {
        return size == LOTTERY_TICKET_SIZE;
    }

    public static boolean isValidMoney(int money) {
        return money % LOTTERY_TICKET_PRICE == 0;
    }

    public int numberCount() {
        return ticketNumbers.size();
    }

    public int match(LotteryTicket ticket) {
        return (int) ticketNumbers.stream()
                .filter(ticket::contains)
                .count();
    }

    protected boolean contains(LotteryNumber number) {
        return ticketNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(ticketNumbers, that.ticketNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumbers);
    }

    @Override
    public String toString() {
        return ticketNumbers.stream()
                .map(LotteryNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
