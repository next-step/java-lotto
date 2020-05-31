package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoShop {

    private final LottoTicketGenerator lottoTicketManualGenerator;
    private final LottoTicketGenerator lottoTicketAutoGenerator;

    public LottoShop(LottoTicketManualGenerator lottoTicketManualGenerator,
                     LottoTicketAutoGenerator lottoTicketAutoGenerator) {
        this.lottoTicketManualGenerator = lottoTicketManualGenerator;
        this.lottoTicketAutoGenerator = lottoTicketAutoGenerator;
    }
    public List<LottoTicket> buy(List<LottoNumbers> lottoNumbersList, int autoBuyAmount) {
        List<LottoTicket> lottoTickets = buyFromManualGenerator(lottoNumbersList);
        lottoTickets.addAll(buyFromAutoGenerator(autoBuyAmount));
        return lottoTickets;
    }

    private List<LottoTicket> buyFromAutoGenerator(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(integer -> lottoTicketAutoGenerator.generate(LottoNumbers.getDefaultLottoNumbers()))
                .collect(toList());
    }

    public List<LottoTicket> buyFromManualGenerator(List<LottoNumbers> lottoNumbersList) {
        return lottoNumbersList.stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(lottoTicketManualGenerator::generate)
                .collect(toList());
    }
}
