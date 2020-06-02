package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoShop {

    private final LottoTicketManualGenerator lottoTicketManualGenerator;
    private final LottoTicketAutoGenerator lottoTicketAutoGenerator;

    public LottoShop(LottoTicketManualGenerator lottoTicketManualGenerator,
                     LottoTicketAutoGenerator lottoTicketAutoGenerator) {
        this.lottoTicketManualGenerator = lottoTicketManualGenerator;
        this.lottoTicketAutoGenerator = lottoTicketAutoGenerator;
    }
    public List<LottoTicket> buy(List<LottoNumbers> manualLottoNumbers, int autoBuyAmount) {
        List<LottoTicket> lottoTickets = buyFromManualGenerator(manualLottoNumbers);
        lottoTickets.addAll(buyFromAutoGenerator(autoBuyAmount));
        return lottoTickets;
    }

    private List<LottoTicket> buyFromAutoGenerator(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(integer -> lottoTicketAutoGenerator.generate(LottoNumbers.getDefaultLottoNumbers()))
                .collect(toList());
    }

    private List<LottoTicket> buyFromManualGenerator(List<LottoNumbers> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(lottoTicketManualGenerator::generate)
                .collect(toList());
    }
}
