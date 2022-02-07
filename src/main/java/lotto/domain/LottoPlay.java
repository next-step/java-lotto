package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class LottoPlay {

    private final LottoTickets lottoTickets;
    private final LottoMachine lottoMachine;
    private final Analyzer analyzer;

    public LottoPlay(InputView inputView) {
        final int totalPrice = inputView.getTotalPrice();
        this.lottoTickets = new LottoTickets(totalPrice);
        this.lottoMachine = new LottoMachine(inputView.getWinNumbers(), inputView.getBonusNumber());
        this.analyzer = new Analyzer(totalPrice);
    }

    public void run() {
        analyzer.calculateTotalWinningMoney(lottoTickets.countCorrectWinNumber(lottoMachine),
            lottoTickets.checkBonusNumber(lottoMachine));
    }

    public List<WinningPrice> getWinningPrices() {
        return analyzer.getWinningPrices();
    }

    public Double calculateProfitPercent() {
        return analyzer.calculateProfitPercent();
    }

    public int getLottoCounts() {
        return lottoTickets.getLottoCounts();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets.getLottoTickets();
    }


}
