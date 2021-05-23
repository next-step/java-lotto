package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Money amountForPurchasingLotto;
    private final LottoStatement lottoStatement = new LottoStatement();
    private double proceedsRate = 0d;

    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public User(Money amountForPurchasingLotto) {
        this.amountForPurchasingLotto = amountForPurchasingLotto;
    }

    public Money amountForPurchasingLotto() {
        return amountForPurchasingLotto;
    }

    public void buyLottoTickets(LottoStore lottoStore) {
        lottoTickets = lottoStore.giveLottoTickets(amountForPurchasingLotto);
    }

    public int countLottoTickets() {
        return lottoTickets.size();
    }

    public void checkHitCount(LottoNumbers winningNumbers) {
        for (LottoTicket lottoTicket: lottoTickets) {
            lottoTicket.calcHitCount(winningNumbers);
            lottoStatement.judge(lottoTicket.hitCount());
        }
    }

    public void printHitCount(OutputView outputView) {
        outputView.printStatement(lottoStatement);
    }

    public void printLottoTickets(OutputView outputView) {
        outputView.printLottoTicketsCount(lottoTickets.size());

        for (LottoTicket lottoTicket: lottoTickets) {
            outputView.printLottoTicket(lottoTicket);
        }
    }

    public void calcProceedsRate(LottoStore lottoStore) {
        Money investment = lottoStore.calcInvestment(lottoTickets.size());
        Money proceeds = lottoStatement.calcProceeds();

        proceedsRate = investment.calcProceedsRate(proceeds);
    }

    public void printProceedsRate(OutputView outputView) {
        outputView.printProceedsRate(proceedsRate);
    }
}
