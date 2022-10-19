package lotto.domain;

import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<Lotto> tickets;

    public LottoTickets(int lottoCount) {
        this.tickets = create(lottoCount);
    }

    public LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    private List<Lotto> create(int lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public List<LottoDto> generateTickets() {
        return tickets.stream().map(LottoDto::new).collect(Collectors.toList());
    }

    public LottoWinning result(Lotto lastWeekTicket) {
        LottoWinning winning = new LottoWinning();
        for (Lotto ticket : tickets) {
            winning.put(LottoPrize.win(lastWeekTicket.matches(ticket)));
        }
        return winning;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
