package lotto.domain;

import java.util.List;

public class LottoPlay {

    private final LottoTickets lottoTickets;
    private final Analyzer analyzer;

    public LottoPlay(final int totalPrice, final LottoGenerator lottoGenerator) {
        this.lottoTickets = new LottoTickets(totalPrice, lottoGenerator);
        this.analyzer = new Analyzer(totalPrice);
    }

    public void run(final LottoMachine lottoMachine) {
        analyzer.calculateTotalWinningMoney(lottoTickets.calculateWinningResult(lottoMachine));
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
