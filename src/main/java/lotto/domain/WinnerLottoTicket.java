package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLottoTicket extends AbstractLottoTicket {

    private WinnerLottoTicket(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static WinnerLottoTicket from(List<Integer> args) {
        return new WinnerLottoTicket(args);
    }

    public List<Long> winnerCount(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets().stream()
            .mapToLong(this::winnerCount)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    }

    private long winnerCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoTicket()
            .stream()
            .filter(number -> this.lottoTicket.contains(number))
            .count();
    }

}
