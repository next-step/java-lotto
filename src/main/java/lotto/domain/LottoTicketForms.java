package lotto.domain;

import java.util.List;

public class LottoTicketForms {
    private final List<LottoTicketForm> lottoTicketForms;

    public static LottoTicketForms of(List<LottoTicketForm> lottoTicketForms) {
        return new LottoTicketForms(lottoTicketForms);
    }

    private LottoTicketForms(List<LottoTicketForm> lottoTicketForms) {
        this.lottoTicketForms = lottoTicketForms;
    }

    public int getSize() {
        return lottoTicketForms.size();
    }

    public List<LottoTicketForm> getLottoTicketForms() {
        return lottoTicketForms;
    }
}
