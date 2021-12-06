package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lottery.dto.LotteryResultDto;
import lottery.dto.LotteryTicketResultDto;

public class LotteryTickets {

    private final List<LotteryTicket> tickets;

    private LotteryTickets(final List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public static LotteryTickets createWithRandomNumbers(final int ticketCount) {
        final List<LotteryTicket> tickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(LotteryTicket.createWithRandomNumbers());
        }

        return new LotteryTickets(tickets);
    }

    public LotteryResultDto lotteryResultDto(final LotteryTicket winningLotteryTicket) {
        final Function<LotteryTicket, Function<LotteryTicket, LotteryTicketResultDto>> resultCreationFunction
            = winningTicket -> ticket -> ticket.lotteryTicketResultDto(winningTicket);

        final List<LotteryTicketResultDto> lotteryTicketResults = tickets.stream()
            .map(resultCreationFunction.apply(winningLotteryTicket))
            .collect(Collectors.toList());

        return LotteryResultDto.of(tickets.size(), lotteryTicketResults);
    }

    public List<LotteryTicket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }
}
