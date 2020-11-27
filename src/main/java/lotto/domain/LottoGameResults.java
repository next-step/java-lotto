package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameResults {

    private LinkedHashMap<PrizeUnit, Integer> prizeUnitCountMap = new LinkedHashMap<>();

    private List<Long> prizeMoney = new ArrayList<>();

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

    public void checkWinningResult(List<LottoNumber> lastWinningNumbers, int bonusNumber) {
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
        winningResults.entrySet().stream()
                .forEach(prizeUnitSet -> prizeMoney.add(prizeUnitSet.getKey().calculate(prizeUnitSet.getValue())));

        Long sum = prizeMoney.stream().collect(Collectors.summingLong(Long::longValue));

        double profit = sum / (double) lottoTickets.getGameMoney();

        return Math.round(profit * 100) / 100.0;
    }

}

