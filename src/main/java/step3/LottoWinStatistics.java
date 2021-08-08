package step3;

public class LottoWinStatistics {

    private final LottoPrice lottoPrice;
    private final DrawnLotto winnersLottoEntry;
    private final MatchGroups matchGroups = new MatchGroups();

    public LottoWinStatistics(LottoPrice price, DrawnLotto winnersLottoEntry) {
        this.lottoPrice = price;
        this.winnersLottoEntry = winnersLottoEntry;
    }

    public void addLottoSample(LottoEntry sampleLottoEntry) {
        Match match = Match.getMatchResult(winnersLottoEntry, sampleLottoEntry);

        this.matchGroups.addLottoOnMatchGroup(match, sampleLottoEntry);
    }

    public void addLottoSamples(LottoBucket lottoBucket) {
        lottoBucket.forEach(this::addLottoSample);
    }

    public double getProfitRate() {
        int totalCost = this.lottoPrice.getQuote(this.matchGroups.countAllLottoEntries());

        if (totalCost == 0) {
            return 0.0;
        }

        double earning = this.matchGroups.keySet().stream()
                .map(w -> w.prize() * this.matchGroups.getBucket(w).size())
                .reduce(Integer::sum)
                .orElse(0);

        return earning / totalCost;
    }

    public int countLottoEntriesByMatch(Match match) {
        return this.matchGroups.countLottoEntriesByMatch(match);
    }
}
