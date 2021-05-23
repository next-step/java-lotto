package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(Money money) {
        lottoTickets = giveLottoTickets(money);
    }

    private List<LottoTicket> giveLottoTickets(Money money) {
        int lottoCount = money.calcLottoCount(LOTTO_TICKET_PRICE);

        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public Money calcInvestment() {
        return new Money(LOTTO_TICKET_PRICE * lottoTickets.size());
    }

    public void checkHitCount(LottoNumbers winningNumbers, LottoStatement lottoStatement) {
        for (LottoTicket lottoTicket: lottoTickets) {
            lottoTicket.calcHitCount(winningNumbers);
            lottoStatement.judge(lottoTicket.hitCount());
        }
    }

    public double calcProceedsRate(LottoStatement lottoStatement) {
        Money investment = calcInvestment();
        Money proceeds = lottoStatement.calcProceeds();

        return investment.calcProceedsRate(proceeds);
    }

    @Override
    public String toString() {
        String result = "";
        for (LottoTicket lottoTicket: lottoTickets) {
            result += lottoTicket.toString() + "\n";
        }

        return result;
    }
}
