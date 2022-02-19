package lotto.domain;

import java.util.List;

public class LottoPlay {

    private final LottoTickets lottoTickets;
    private final Analyzer analyzer;

    public LottoPlay(final int totalPrice, final int manualLottoNumber,
        final List<List<Integer>> manualLottos) {
        this.lottoTickets = new LottoTickets(totalPrice, manualLottoNumber, manualLottos);
        this.analyzer = new Analyzer(totalPrice);
    }

    public LottoPlay(final int totalPrice, final int manualLottoNumber) {
        this.lottoTickets = new LottoTickets(totalPrice, manualLottoNumber);
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

    public int getLottoRandomMatchCount() {
        return lottoTickets.getRandomLottoCounts();
    }

    public int getLottoManualMatchCount() {
        return lottoTickets.getManualCount();
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets.getLottoTickets();
    }

}
