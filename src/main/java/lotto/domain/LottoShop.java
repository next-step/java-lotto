package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {

    private LottoTicketGenerator lottoTicketGenerator;

    public LottoShop(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public List<LottoTicket> buy(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(integer -> lottoTicketGenerator.generate(LottoNumber.getDefaultLottoNumbers()))
                .collect(Collectors.toList());
    }
}
