package step4;

import step4.enums.DrawResult;

public class LottoWinStatistics {

    private final LottoPrice lottoPrice;
    private final DrawnLotto winnersLottoEntry;
    private final DrawResultGroups drawResultGroups = new DrawResultGroups();

    public LottoWinStatistics(LottoPrice price, DrawnLotto winnersLottoEntry) {
        this.lottoPrice = price;
        this.winnersLottoEntry = winnersLottoEntry;
    }

    public void addLottoSample(LottoEntry sampleLottoEntry) {
        DrawResult drawResult = winnersLottoEntry.getDrawResult(sampleLottoEntry);

        drawResultGroups.addLottoOnMatchGroup(drawResult, sampleLottoEntry);
    }

    public void addLottoSamples(LottoBucket lottoBucket) {
        lottoBucket.forEach(this::addLottoSample);
    }

    public double getProfitRate() {
        int totalCost = lottoPrice.getQuote(drawResultGroups.countAllLottoEntries());

        if (totalCost == 0) {
            return 0.0;
        }

        double earning = drawResultGroups.keySet().stream()
                .parallel()
                .map(w -> w.prize() * drawResultGroups.getBucket(w).size())
                .reduce(Integer::sum)
                .orElse(0);

        return earning / totalCost;
    }

    public int countLottoEntriesByMatch(DrawResult drawResult) {
        return drawResultGroups.countLottoEntriesByMatch(drawResult);
    }
}
