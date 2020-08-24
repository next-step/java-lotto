package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class PublishedLottoTicket {

    private Set<LottoTicket> publishedLottoTicket;

    private PublishedLottoTicket(int lottoTicketCounts) {
        this.publishedLottoTicket = new HashSet<>();
        publishLottoTicket(lottoTicketCounts);
    }

    public static PublishedLottoTicket valueOf(int lottoTicketCounts) {
        return new PublishedLottoTicket(lottoTicketCounts);
    }

    private void publishLottoTicket(int lottoTicketCounts) {
        for (int i = 0; i < lottoTicketCounts; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.generateLottoNumber();
            this.publishedLottoTicket.add(LottoTicket.valueOf(lottoNumbers));
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return publishedLottoTicket;
    }

}
