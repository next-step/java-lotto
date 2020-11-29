package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LottoBundle {

    private final Order order;
    private List<LottoTicket> lottoTickets;

    public LottoBundle(List<LottoTicket> lottoTickets, Order order) {
        this.order = order;
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> export() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public LottoStatistic draw(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
        return new LottoStatistic(lottoTickets.stream()
                .map(item -> item.draw(lottoNumbers, bonusNumber))
                .collect(Collectors.toList()),
                lottoTickets.size() * LottoTicket.PRICE);
    }

    public Order getOrder(){
        return this.order;
    }

}
