package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {

    final private List<LottoTicket> tickets;

    public Lotto(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<LottoNumber> numbers = LottoNumberGenerator.generateLottoNumbers();
            tickets.add(new LottoTicket(numbers));
        }

        this.tickets = tickets;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public void checkWin(List<LottoNumber> winningNumbers) {
        for (LottoTicket ticket : tickets) {
            ticket.checkRank(winningNumbers);
        }
    }

    public BigDecimal getReturnRate() {
        BigDecimal totalAmount = new BigDecimal(tickets.size() * LottoTicket.TICKET_PRICE);
        BigDecimal totalPrize = new BigDecimal(getTotalPrize());
        return totalPrize.divide(totalAmount, 2, RoundingMode.DOWN);
    }

    private long getTotalPrize() {
        long totalPrize = 0;
        for (LottoTicket ticket : tickets) {
            totalPrize += ticket.getPrizeAmount();
        }

        return totalPrize;
    }

    public Map<LottoRank, Long> getWinningStat() {
        Map<LottoRank, Long> stat = new HashMap<>();

        for (LottoRank rank: LottoRank.values()) {
            Long count = tickets.stream()
                .filter(lottoTicket -> lottoTicket.isRank(rank))
                .count();

            stat.put(rank, count);
        }

        return stat;
    }
}
