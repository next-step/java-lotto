package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PublishedLottoTicket {

    private final Set<LottoTicket> publishedLottoTicket;

    private PublishedLottoTicket(int lottoTicketCount) {
        this.publishedLottoTicket = new HashSet<>();
        publishLottoTicket(lottoTicketCount);
    }

    public static PublishedLottoTicket ofLottoTicketCount(int lottoTicketCount) {
        return new PublishedLottoTicket(lottoTicketCount);
    }

    private void publishLottoTicket(int lottoTicketCounts) {
        LottoMachine lottoMachine = new LottoMachine();
        for (int i = 0; i < lottoTicketCounts; i++) {
            Set<LottoNumber> lottoNumbers = lottoMachine.generateLottoNumber();
            this.publishedLottoTicket.add(new LottoTicket(lottoNumbers));
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return Collections.unmodifiableSet(publishedLottoTicket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishedLottoTicket that = (PublishedLottoTicket) o;
        return Objects.equals(publishedLottoTicket, that.publishedLottoTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishedLottoTicket);
    }
}
