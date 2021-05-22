package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final Money amountForPurchasingLotto;

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

    public void checkWinning(WinningNumber winningNumber) {
        for(LottoTicket lottoTicket: lottoTickets) {
            winningNumber.checkWinning(lottoTicket);
        }
    }

    public void printHitCount(OutputView outputView) {
        for(LottoTicket lottoTicket: lottoTickets) {
            outputView.print(lottoTicket.hitCount());
            outputView.print("\n");
        }
    }

    public void printLottoTickets(OutputView outputView) {
        for(LottoTicket lottoTicket: lottoTickets) {
            outputView.print(lottoTicket);
            outputView.print("\n");
        }
    }
}
