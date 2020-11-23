package lotto.domain;

import static lotto.domain.LottoGameConfig.*;
import java.util.*;
import java.util.stream.Collectors;

public class LottoGameResults {

    private LinkedHashMap<WinResult, Integer> prizeUnitCountMap = new LinkedHashMap<>();

    private List<Long> prizeMoney = new ArrayList<>();

    private LottoTickets lottoTickets;

    public LottoGameResults(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        initializePrizeUnit();
    }

    private void initializePrizeUnit() {
        Arrays.stream(PrizeUnit.values())
                .forEach(prizeUnit -> prizeUnitCountMap.put(new WinResult(prizeUnit.prizeUnitCount, prizeUnit == PrizeUnit.SECOND_GRADE ? true:false), 0));
    }

    public LottoTickets getLottoIssueResult() {
        return this.lottoTickets;
    }

    public void checkWinningResult(List<Integer> lastWinningNumbers, int bonusNumber) {
        lottoTickets.getLottoTickets().stream()
                .forEach(lottoTicket -> recordWinningResult(lottoTicket.countWinningNumbers(lastWinningNumbers, bonusNumber)));
    }

    public void recordWinningResult(WinResult winResult) {
        if (winResult.prizeUnit != 0) {
            int previousUnitCount = prizeUnitCountMap.get(winResult);
            previousUnitCount = previousUnitCount + 1;
            prizeUnitCountMap.put(winResult, previousUnitCount);
        }
    }




    public Map<WinResult, Integer> getWinningResultRecord() {
        return prizeUnitCountMap;
    }

    public double getProfit(Map<WinResult, Integer> winningResults) {
        winningResults.entrySet().stream()
                .forEach(set -> prizeMoney.add(PrizeUnit.calculate(set.getKey().prizeUnit, set.getKey().isMatchBonusNumber, set.getValue())));

        Long sum = prizeMoney.stream().collect(Collectors.summingLong(Long::longValue));

        double profit = sum / (double) lottoTickets.getGameMoney();

        return Math.round(profit * 100) / 100.0;
    }

}

