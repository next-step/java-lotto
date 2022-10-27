package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoTicket> tickets;

    public Lotto(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static Lotto of(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<LottoNumber> numbers = LottoNumberGenerator.generateLottoNumbers();
            tickets.add(new LottoTicket(numbers));
        }

        return new Lotto(tickets);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public BigDecimal getReturnRate(Map<LottoRank, Long> winningStat) {
        BigDecimal totalAmount = new BigDecimal(tickets.size() * LottoTicket.TICKET_PRICE);
        BigDecimal totalPrize = new BigDecimal(getTotalPrize(winningStat));
        return totalPrize.divide(totalAmount, 2, RoundingMode.DOWN);
    }

    private long getTotalPrize(Map<LottoRank, Long> winningStat) {
        long totalPrize = 0;

        for (LottoRank rank : winningStat.keySet()) {
            totalPrize += rank.getPrize() * winningStat.get(rank);
        }

        return totalPrize;
    }

    public Map<LottoRank, Long> getWinningStat(List<LottoNumber> winningNumbers, LottoNumber bonusBall) {
        Map<LottoRank, Long> stat = Arrays.stream(LottoRank.values()).collect(Collectors.toMap(
            Function.identity(), rank -> 0L));

        for (LottoTicket ticket: tickets) {
            LottoRank rank = ticket.getRank(winningNumbers, bonusBall);
            stat.put(rank, stat.get(rank) + 1);
        }

        return stat;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket ticket : tickets) {
            stringBuilder.append(ticket.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
