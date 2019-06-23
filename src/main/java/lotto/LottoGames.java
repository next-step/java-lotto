package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private static final int lottoOneGamePrice = 1000;
    private static final int summaryInitNumber = 0;
    private static int summaryCount = 4;
    private static final String summaryEnumSuffix = "개 일치 ";
    private static List <Integer> summaryWinnerCounts;

    private List <Lotto> lottos;

    public LottoGames(List <Lotto> lottos) {
        createSummaryWinnerCounts();
        this.lottos = lottos;
    }

    public double rateOfReturn() {
        return Math.round((sumWinnerPrice() / (float) totalLottoGamePrice()) * 100) / 100.0;
    }

    private int sumWinnerPrice() {
        return lottos.stream().mapToInt(lotto -> lotto.getWinnerPrice()).sum();
    }

    private int totalLottoGamePrice() {
        return lottoOneGamePrice * lottos.size();
    }

    private void createSummaryWinnerCounts() {
        summaryWinnerCounts = new ArrayList <>();
        while (summaryCount > summaryInitNumber) {
            summaryWinnerCounts.add(summaryInitNumber);
            summaryCount--;
        }
    }

    public List <Integer> getSummaryWinnerCounts() {
        for (Lotto lotto : lottos) {
            String summaryWinnerKey = lotto.getWinnerNumberCount() + summaryEnumSuffix;
            int summaryIndex = LottoEnum.findByPrice(summaryWinnerKey).summaryNumber();
            int summaryPrice = LottoEnum.findByPrice(summaryWinnerKey).price();
            if(summaryPrice > 0){
                summaryWinnerCounts.set(summaryIndex, summaryWinnerCounts.get(summaryIndex) + 1);
            }
        }
        return summaryWinnerCounts;
    }

}
