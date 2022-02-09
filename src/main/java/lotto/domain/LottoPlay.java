package lotto.domain;

import java.util.List;

public class LottoPlay {

    private final LottoTickets lottoTickets;
    private final Analyzer analyzer;

    public LottoPlay(int totalPrice) {
        this.lottoTickets = new LottoTickets(totalPrice);
        this.analyzer = new Analyzer(totalPrice);
    }

    public void run(LottoMachine lottoMachine) {
        analyzer.calculateTotalWinningMoney(
            lottoTickets.countCorrectWinNumber(lottoMachine),
            lottoTickets.checkBonusNumber(lottoMachine)
        );
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
