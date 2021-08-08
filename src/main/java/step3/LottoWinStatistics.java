package step3;

import step3.enums.Match;

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

        matchGroups.addLottoOnMatchGroup(match, sampleLottoEntry);
    }

    public void addLottoSamples(LottoBucket lottoBucket) {
        lottoBucket.forEach(this::addLottoSample);
    }

    public double getProfitRate() {
        int totalCost = lottoPrice.getQuote(matchGroups.countAllLottoEntries());

        if (totalCost == 0) {
            return 0.0;
        }

        double earning = matchGroups.keySet().stream()
                .parallel()
                .map(w -> w.prize() * matchGroups.getBucket(w).size())
                .reduce(Integer::sum)
                .orElse(0);

        return earning / totalCost;
    }

    public int countLottoEntriesByMatch(Match match) {
        return matchGroups.countLottoEntriesByMatch(match);
    }
}
