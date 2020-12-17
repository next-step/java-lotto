package lotto.domain;

import lotto.util.StringSplitter;

import java.util.*;

public class PublishedLottoTicket {

    private final Set<LottoTicket> publishedLottoTicket;

    private PublishedLottoTicket(int autoLottoTicketCount, List<String> manualLottoNumbers) {
        this.publishedLottoTicket = new HashSet<>();
        publishAutoLottoTicket(autoLottoTicketCount);
        publishManualLottoTicket(manualLottoNumbers);
    }

    public void publishAutoLottoTicket(int lottoTicketCounts) {
        LottoMachine lottoMachine =  LottoMachine.instance();
        for (int i = 0; i < lottoTicketCounts; i++) {
            LottoTicket autoLottoTicket = lottoMachine.generateAutoLottoNumber();
            this.publishedLottoTicket.add(autoLottoTicket);
        }
    }

    public void publishManualLottoTicket(List<String> manualLottoNumbers) {
        LottoMachine lottoMachine = LottoMachine.instance();
        for (String lottoNumber : manualLottoNumbers) {
            LottoTicket manualLottoTicket = lottoMachine.generateManualLottoNumbers(StringSplitter.splitText(lottoNumber));
            this.publishedLottoTicket.add(manualLottoTicket);
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return Collections.unmodifiableSet(publishedLottoTicket);
    }

    public static class Builder {
        int autoLottoTicketCount;
        List<String> manualLottoNumbers;

        public Builder autoLottoTicketCount(int autoLottoTicketCount) {
            this.autoLottoTicketCount = autoLottoTicketCount;
            return this;
        }

        public Builder manualLottoNumbers(List<String> manualLottoNumbers) {
            this.manualLottoNumbers = manualLottoNumbers;
            return this;
        }

        public PublishedLottoTicket build() {
            return new PublishedLottoTicket(autoLottoTicketCount, manualLottoNumbers);
        }
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
