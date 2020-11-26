package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class LottoBundle {

    private final int auto;
    private final int manual;
    private List<LottoTicket> lottoTicketList;

    public LottoBundle(List<LottoTicket> lottoTickets, int auto, int manual) {
        this.auto = auto;
        this.manual = manual;
        this.lottoTicketList = Collections.unmodifiableList(lottoTickets);
    }

    public int getTicketCount() {
        return lottoTicketList.size();
    }

    public List<LottoTicket> export() {
        return Collections.unmodifiableList(lottoTicketList);
    }

    public LottoStatistic draw(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
        return new LottoStatistic(lottoTicketList.stream()
                .map(item -> item.draw(lottoNumbers, bonusNumber))
                .collect(Collectors.toList()),
                lottoTicketList.size() * LottoTicket.PRICE);
    }

    public int getAuto() {
        return this.auto;
    }

    public int getManual() {
        return this.manual;
    }
}
