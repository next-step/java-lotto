package domain.lottery;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LotteryTicket {
    private final List<LotteryNumber> ticketNumbers;

    private static final int COUNT_OF_LOTTERY_NUMBERS = 6;

    private LotteryTicket(List<LotteryNumber> ticketNumbers) {
        this.ticketNumbers = ticketNumbers;

        ticketNumbers = ticketNumbers.stream().distinct().collect(Collectors.toList());

        if (ticketNumbers.size() < COUNT_OF_LOTTERY_NUMBERS) {
            throw new IllegalArgumentException("복권번호가 중복됩니다.");
        }
    }

    public static LotteryTicket of(List<LotteryNumber> ticketNumbers) {
        return new LotteryTicket(Optional.ofNullable(ticketNumbers).get());
    }

    public List<LotteryNumber> getTicketNumbers() {
        return ticketNumbers;
    }

    public void add(LotteryNumber lotteryNumber) {
        ticketNumbers.add(lotteryNumber);
    }
}
