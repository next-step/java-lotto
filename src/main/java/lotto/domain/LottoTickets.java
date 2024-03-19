package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final static int LOTTO_PRICE = 1000;
    private final static long THREE_MATCH_PRIZE = 5_000;
    private final static long FOUR_MATCH_PRIZE = 50_000;
    private final static long FIVE_MATCH_PRIZE = 1_500_000;
    private final static long SIX_MATCH_PRIZE = 2_000_000_000;

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(Amount amount) {
        this.lottoTicketList = IntStream.range(0, amount.value() / LOTTO_PRICE)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTicketList() {
        return lottoTicketList;
    }

    public int size() {
        return lottoTicketList.size();
    }

    public int matchTicketCount(WinningNumbers winningNumbers, int matchNumberCount) {
        return (int) lottoTicketList.stream()
                .filter(lottoTicket -> lottoTicket.getMatchCount(winningNumbers) == matchNumberCount)
                .count();
    }

    public double earningsRate(WinningNumbers winningNumbers) {
        return Math.floor(100 * (double) earnings(winningNumbers) / (size() * LOTTO_PRICE))/100.0;
    }

    private long earnings(WinningNumbers winningNumbers) {
        return matchTicketCount(winningNumbers, 3) * THREE_MATCH_PRIZE
                + matchTicketCount(winningNumbers, 4) * FOUR_MATCH_PRIZE
                + matchTicketCount(winningNumbers, 5) * FIVE_MATCH_PRIZE
                + matchTicketCount(winningNumbers, 6) * SIX_MATCH_PRIZE;
    }

}
