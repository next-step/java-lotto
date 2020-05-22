package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;

import java.util.List;

public class BuyOutputView {
    private LottoTickets lottoTickets;

    public BuyOutputView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void printResult() {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        List<LottoTicket> values = lottoTickets.getValues();
        String result = values.stream()
                .map(LottoTicket::sort)
                .map(LottoTicket::toString)
                .reduce((previousTickets, lottoTicket) -> previousTickets + "\n" + lottoTicket)
                .get();

        System.out.println(result);
    }
}
