package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketMaker {
    private final int price;
    private final List<String> manualNumbers;

    public LottoTicketMaker(int price, List<String> manualNumbers) {
        this.price = price;
        this.manualNumbers = manualNumbers;
        validateLottoTicketMaker();
    }

    private void validateLottoTicketMaker() {
        if (getManualCount() > getTotalCount(price)) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 총 로또 수보다 많습니다.");
        }
    }

    public LottoTickets createLottoTickets() {
        return createManualLottoTickets().merge(createAutoLottoTickets());
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
