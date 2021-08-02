package step2;

public class LottoWinStatistics {

    private final LottoEntry winnersLottoEntry;
    private final LottoWinGroups lottoWinGroups = new LottoWinGroups();

    public LottoWinStatistics(LottoEntry winnersLottoEntry) {
        this.winnersLottoEntry = winnersLottoEntry;
    }

    public void addLottoSample(LottoEntry sampleLottoEntry) {
        LottoWin lottoWin = LottoWin.getMatchResult(winnersLottoEntry, sampleLottoEntry);
        lottoWinGroups.addLottoOnLottoWinGroup(lottoWin, sampleLottoEntry);
    }

    public void addLottoSamples(LottoBucket lottoBucket) {
        lottoBucket.forEach(this::addLottoSample);
    }

    public double getProfitRate(int lottoUnitPrice) {
        int totalCost = lottoUnitPrice * this.lottoWinGroups.countAllLottoEntries();

        double earning = this.lottoWinGroups.keySet().stream()
                .map(w -> w.prize() * this.lottoWinGroups.get(w).size())
                .reduce(Integer::sum)
                .orElse(0);

        if (totalCost == 0) {
            return 0.0;
        }

        return earning / totalCost;
    }

    public int countLottoEntriesByLottoWin(LottoWin lottoWin) {
        return this.lottoWinGroups.countLottoEntriesByLottoWin(lottoWin);
    }
}
