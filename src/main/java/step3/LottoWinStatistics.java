package step3;

public class LottoWinStatistics {

    private final LottoPrice lottoPrice;
    private final DrawnLotto winnersLottoEntry;
    private final LottoWinGroups lottoWinGroups = new LottoWinGroups();

    public LottoWinStatistics(LottoPrice price, DrawnLotto winnersLottoEntry) {
        this.lottoPrice = price;
        this.winnersLottoEntry = winnersLottoEntry;
    }

    public void addLottoSample(LottoEntry sampleLottoEntry) {
        LottoWin lottoWin = LottoWin.getMatchResult(winnersLottoEntry, sampleLottoEntry);
        lottoWinGroups.addLottoOnLottoWinGroup(lottoWin, sampleLottoEntry);
    }

    public void addLottoSamples(LottoBucket lottoBucket) {
        lottoBucket.forEach(this::addLottoSample);
    }

    public double getProfitRate() {
        int totalCost = this.lottoPrice.getQuote(this.lottoWinGroups.countAllLottoEntries());

        if (totalCost == 0) {
            return 0.0;
        }

        double earning = this.lottoWinGroups.keySet().stream()
                .map(w -> w.prize() * this.lottoWinGroups.get(w).size())
                .reduce(Integer::sum)
                .orElse(0);

        return earning / totalCost;
    }

    public int countLottoEntriesByLottoWin(LottoWin lottoWin) {
        return this.lottoWinGroups.countLottoEntriesByLottoWin(lottoWin);
    }
}
