package lottoauto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int amountForPurchasingLotto;

    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public User(int amountForPurchasingLotto) {
        this.amountForPurchasingLotto = amountForPurchasingLotto;
    }

    public int amountForPurchasingLotto() {
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

    public void printLottoTickets(OutputView outputView) {
        for(LottoTicket lottoTicket: lottoTickets) {
            outputView.print(lottoTicket);
            outputView.print("\n");
        }
    }
}
