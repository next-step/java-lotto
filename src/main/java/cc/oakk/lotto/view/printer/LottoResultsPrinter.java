package cc.oakk.lotto.view.printer;

import cc.oakk.lotto.model.Lotto;
import cc.oakk.lotto.model.prizeprovider.LottoPrizeProvider;
import cc.oakk.lotto.model.LottoResults;
import cc.oakk.lotto.model.Rank;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResultsPrinter<T> extends StringPrinter<LottoResults> {
    private static final Rank[] printingRanks = new Rank[] { Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST };

    private final LottoPrizeProvider<T> provider;
    private final int lottoPrice;

    public LottoResultsPrinter(LottoPrizeProvider<T> provider, int lottoPrice) {
        super();
        this.provider = provider;
        this.lottoPrice = lottoPrice;
    }

    public LottoResultsPrinter(Printer<String> stringPrinter, LottoPrizeProvider<T> provider, int lottoPrice) {
        super(stringPrinter);
        this.provider = provider;
        this.lottoPrice = lottoPrice;
    }

    @Override
    public void print(LottoResults results) {
        StringBuilder builder = new StringBuilder();

        for (Rank printingRank : printingRanks) {
            int matchingCount = Lotto.NUMBER_COUNT - printingRank.getDifferentCount();
            builder.append(String.format("%d개 일치 (%s)- %d개\n",
                    matchingCount,
                    provider.getPrizeByRank(printingRank),
                    results.getRankCount(printingRank)));
        }

        builder.append(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
                calculateRevenueRate(results)));
        stringPrinter.print(builder.toString());
    }

    private double calculateRevenueRate(LottoResults results) {
        throwIfNull(results);
        return (double) results.calculateRevenue(provider) / (results.size() * lottoPrice);
    }
}
