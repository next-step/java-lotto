package lotto.ui;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.shop.Money;

import java.util.List;

public class BuyOutputView {
    private LottoTickets lottoTickets;
    private int manualLottoCount;
    private Money money;

    public BuyOutputView(LottoTickets lottoTickets, int manualLottoCount, Money money) {
        this.lottoTickets = lottoTickets;
        this.manualLottoCount = manualLottoCount;
        this.money = money;
    }

    public void printResult() {
        System.out.println(System.lineSeparator() +
                "수동으로 " +
                this.manualLottoCount +
                "장, " +
                "자동으로 " +
                (this.money.howManyLottoTickets() - this.manualLottoCount) +
                "개를 구매했습니다.");

        List<LottoTicket> values = lottoTickets.getValues();
        String result = values.stream()
                .map(LottoTicket::toString)
                .reduce((previousTickets, lottoTicket) -> previousTickets + "\n" + lottoTicket)
                .get();

        System.out.println(result);
    }
}
