package lotto.domain;

import java.util.*;

public class LottoGameResults {

    private LinkedHashMap<PrizeUnit, Integer> prizeUnitCountMap = new LinkedHashMap<>();

    private LottoTickets lottoTickets;

    public LottoGameResults(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        initializePrizeUnit();
    }

    private void initializePrizeUnit() {
        Arrays.stream(PrizeUnit.values())
                .forEach(prizeUnit -> prizeUnitCountMap.put(prizeUnit, 0));
    }

    public LottoTickets getLottoIssueResult() {
        return this.lottoTickets;
    }

    public void checkWinningResult(List<LottoNumber> lastWinningNumbers, LottoNumber bonusNumber) {
        List<PrizeUnit> prizeUnitList = lottoTickets.scoreWinningResult(lastWinningNumbers, bonusNumber);
        recordWinningResult(prizeUnitList);
    }

    public void recordWinningResult(List<PrizeUnit> prizeUnitList) {
        prizeUnitList.stream().filter(prizeUnit -> prizeUnit.prizeUnitCount != 0)
                .forEach(prizeUnit -> prizeUnitCountMap.put(prizeUnit, prizeUnitCountMap.get(prizeUnit)+1));
    }

    public Map<PrizeUnit, Integer> getWinningResultRecord() {
        return prizeUnitCountMap;
    }

    public double getProfit(Map<PrizeUnit, Integer> winningResults) {
        long sum = winningResults.entrySet()
                .stream().mapToLong(entry -> entry.getKey().calculate(entry.getValue()))
                .sum();

        double profit = sum / (double) lottoTickets.getGameMoney();

        return Math.round(profit * 100) / 100.0;
    }

}

