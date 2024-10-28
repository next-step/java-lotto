package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketMaker {
    private final int price;
    private final List<String> manualNumbers;

    public LottoTicketMaker(int price, List<String> manualNumbers) {
        this.price = price;
        this.manualNumbers = manualNumbers;
    }

    public LottoTickets createManualLottoTickets() {
        List<LottoTicket> lottoTickets = manualNumbers.stream()
                                                      .map(LottoTicket::createByString)
                                                      .collect(Collectors.toList());
        return new LottoTickets(lottoTickets);
    }

    public LottoTickets createAutoLottoTickets() {
        return LottoTickets.createByCount(getAutoCount());
    }

    private int getAutoCount() {
        return getTotalCount(price) - getManualCount();
    }

    private int getTotalCount(int price) {
        return price / LottoTicket.PRICE;
    }

    private int getManualCount() {
        return manualNumbers.size();
    }
}
