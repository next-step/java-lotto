package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGameResults {

    private static final int LOTTO_TICKET_NUMBER_COUNT = 6;
    private static final int MIN_COUNT_TO_PRIZE = 3;
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "([,\\d])+";

    private Map<Integer, Integer> prizeUnitCountMap = new HashMap<>();

    private LinkedList<LottoGameResult> lottoGameResults;

    private List<Long> prizeMoney = new ArrayList<>();

    private int gameMoney;


    public LottoGameResults(int gameMoney){
        this.gameMoney = gameMoney;
        this.lottoGameResults = new LinkedList<>();

        initializePrizeUnit();

    }

    private void initializePrizeUnit() {
        Arrays.stream(PrizeUnit.values())
                .forEach(prizeUnit -> prizeUnitCountMap.put(prizeUnit.prizeUnitCount, 0));
    }

    public void addResult(LottoGameResult lottoGameResult) {
        lottoGameResults.add(lottoGameResult);
    }

    public LinkedList<LottoGameResult> getLottoGameResults() {
        return lottoGameResults;
    }

    public void checkWinningResult(String lastWinningNumbersInput) {

        List<Integer> lastWinningNumbers = addLastWinningNumber(lastWinningNumbersInput);

        lottoGameResults.stream()
                .forEach(lottoGameResult -> recordWinningResult(countWinningNumbers(lottoGameResult.getLottoGameResult(), lastWinningNumbers)));
    }

    public List<Integer> addLastWinningNumber(String lastWinningNumbersInput) {
        List<Integer> lastWinningNumbers = new ArrayList<>();
        Arrays.stream(validateLastWinningNumbers(lastWinningNumbersInput)).forEach(i -> lastWinningNumbers.add(Integer.parseInt(i.trim())));
        return lastWinningNumbers;
    }

    public String[] validateLastWinningNumbers(String lastWinningNumbersInput) {
        if(!lastWinningNumbersInput.matches(WINNING_NUMBER_PATTERN)){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }
        String[] lastWinningNumbers = splitWinningNumber(lastWinningNumbersInput);

        if(lastWinningNumbers.length != LOTTO_TICKET_NUMBER_COUNT){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }

        return lastWinningNumbers;
    }

    private String[] splitWinningNumber(String lastWinningNumbersInput) {
        return lastWinningNumbersInput.split(WINNING_NUMBER_DELIMITER);
    }

    public void recordWinningResult(int winningNumberCount) {
        if(winningNumberCount != 0){
            int previousUnitCount = prizeUnitCountMap.get(winningNumberCount);
            previousUnitCount = previousUnitCount+1;
            prizeUnitCountMap.put(winningNumberCount, previousUnitCount);
        }
    }

    public int countWinningNumbers(List<Integer> lottoGameResult, List<Integer> lastWinningNumbers) {
        List<Integer> winningsNumber = lottoGameResult
                .stream().filter(element -> lastWinningNumbers.contains(element)).collect(Collectors.toList());

        if(winningsNumber.size() >= MIN_COUNT_TO_PRIZE){
            return winningsNumber.size();
        }

        return 0;

    }

    public Map<Integer, Integer> getWinningResultRecord(){
        return prizeUnitCountMap;
    }


    public double getProfit(Map<Integer, Integer> winningResults) {
        winningResults.entrySet().stream().forEach(set -> prizeMoney.add(PrizeUnit.calculate(set.getKey(), set.getValue())));

        Long sum = prizeMoney.stream().collect(Collectors.summingLong(Long::longValue));

        double profit = sum/(double)gameMoney;

        return Math.round(profit * 100)/100.0;
    }
}
