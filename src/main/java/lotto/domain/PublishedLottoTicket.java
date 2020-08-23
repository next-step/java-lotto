package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class PublishedLottoTicket {

    private Set<LottoTicket> publishedLottoTicket;

    public PublishedLottoTicket(int lottoTicketCounts) {
        this.publishedLottoTicket = new HashSet<>();
        publishLottoTicket(lottoTicketCounts);
    }

    private void publishLottoTicket(int lottoTicketCounts) {
        for (int i = 0; i < lottoTicketCounts; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.generateLottoNumber();
            this.publishedLottoTicket.add(new LottoTicket(lottoNumbers));
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return publishedLottoTicket;
    }

}
