package lotto.domain;

import lotto.view.InputView;

import java.util.HashSet;
import java.util.Set;

public class PublishedLottoTicket {

    private Set<LottoTicket> publishedLottoTicket;

    private PublishedLottoTicket(int lottoTicketCounts, int manualLottoCounts) {
        this.publishedLottoTicket = new HashSet<>();
        publishAutoLottoTicket(lottoTicketCounts);
        publishManualLottoTicket(manualLottoCounts);
    }

    private void publishAutoLottoTicket(int lottoTicketCounts) {
        for (int i = 0; i < lottoTicketCounts; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.generateLottoNumber();
            this.publishedLottoTicket.add(LottoTicket.valueOf(lottoNumbers));
        }
    }

    private void publishManualLottoTicket(int manualLottoCounts) {
        for (int i = 0; i < manualLottoCounts; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.createManualLottoNumbers(InputView.inputManualLottoNumbers());
            this.publishedLottoTicket.add(LottoTicket.valueOf(lottoNumbers));
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return publishedLottoTicket;
    }

    public static class PublishedLottoTicketBuilder {
        int autoLottoTicketCounts;
        int manualLottoCounts;

        public PublishedLottoTicketBuilder autoLottoTicketCounts(int autoLottoTicketCounts) {
            this.autoLottoTicketCounts = autoLottoTicketCounts;
            return this;
        }

        public PublishedLottoTicketBuilder manualLottoCounts(int manualLottoCounts) {
            this.manualLottoCounts = manualLottoCounts;
            return this;
        }

        public PublishedLottoTicket build() {
            return new PublishedLottoTicket(autoLottoTicketCounts, manualLottoCounts);
        }
    }

}
