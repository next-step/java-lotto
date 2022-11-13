package domain.lottery;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LotteryTicket {
    private final List<LotteryNumber> ticketNumbers;
    private final Set<LotteryNumber> SIEVE = new HashSet<>();

    private LotteryTicket(List<LotteryNumber> ticketNumbers) {
        this.ticketNumbers = ticketNumbers;

        SIEVE.addAll(ticketNumbers);

        if (SIEVE.size() != ticketNumbers.size()) throw new IllegalArgumentException("복권번호가 중복됩니다.");
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
