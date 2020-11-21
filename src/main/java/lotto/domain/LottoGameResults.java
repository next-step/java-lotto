package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameResults {

    private static final int LOTTO_TICKET_NUMBER_COUNT = 6;
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "([,\\d])+";

    private Map<Integer, Integer> prizeUnitCountMap = new HashMap<>();

    private List<Long> prizeMoney = new ArrayList<>();

    private LottoTickets lottoTickets;

    public LottoGameResults(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        initializePrizeUnit();
    }

    private void initializePrizeUnit() {
        Arrays.stream(PrizeUnit.values())
                .forEach(prizeUnit -> prizeUnitCountMap.put(prizeUnit.prizeUnitCount, 0));
    }

    public LottoTickets getLottoIssueResult() {
        return this.lottoTickets;
    }


    public void checkWinningResult(String lastWinningNumbersInput) {

        List<Integer> lastWinningNumbers = addLastWinningNumber(lastWinningNumbersInput);

        lottoTickets.getLottoTickets().stream()
                .forEach(lottoTicket -> recordWinningResult(lottoTicket.countWinningNumbers(lastWinningNumbers)));
    }

    public void recordWinningResult(int winningNumberCount) {
        if (winningNumberCount != 0) {
            int previousUnitCount = prizeUnitCountMap.get(winningNumberCount);
            previousUnitCount = previousUnitCount + 1;
            prizeUnitCountMap.put(winningNumberCount, previousUnitCount);
        }
    }

    public List<Integer> addLastWinningNumber(String lastWinningNumbersInput) {
        List<Integer> lastWinningNumbers = new ArrayList<>();
        Arrays.stream(validateLastWinningNumbers(lastWinningNumbersInput)).forEach(i -> lastWinningNumbers.add(Integer.parseInt(i.trim())));
        return lastWinningNumbers;
    }

    public String[] validateLastWinningNumbers(String lastWinningNumbersInput) {
        if (!lastWinningNumbersInput.matches(WINNING_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }
        String[] lastWinningNumbers = splitWinningNumber(lastWinningNumbersInput);

        if (lastWinningNumbers.length != LOTTO_TICKET_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }

        return lastWinningNumbers;
    }

    private String[] splitWinningNumber(String lastWinningNumbersInput) {
        return lastWinningNumbersInput.split(WINNING_NUMBER_DELIMITER);
    }




    public Map<Integer, Integer> getWinningResultRecord() {
        return prizeUnitCountMap;
    }


    public double getProfit(Map<Integer, Integer> winningResults) {
        winningResults.entrySet().stream().forEach(set -> prizeMoney.add(PrizeUnit.calculate(set.getKey(), set.getValue())));

        Long sum = prizeMoney.stream().collect(Collectors.summingLong(Long::longValue));

        double profit = sum / (double) lottoTickets.getGameMoney();

        return Math.round(profit * 100) / 100.0;
    }
}

