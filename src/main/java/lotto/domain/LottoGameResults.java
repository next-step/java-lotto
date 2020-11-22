package lotto.domain;

import static lotto.domain.LottoGameConfig.*;
import java.util.*;
import java.util.stream.Collectors;

public class LottoGameResults {

    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String WINNING_NUMBER_PATTERN = "([,\\d])+";
    private static final String BONUS_NUMBER_PATTERN = "([\\d])+";

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


    public void checkWinningResult(String lastWinningNumbersInput, String bonusNumberValue) {

        List<Integer> lastWinningNumbers = addLastWinningNumber(lastWinningNumbersInput);
        int bonusNumber = validateBonusNumber(bonusNumberValue);

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

        if(Arrays.stream(lastWinningNumbers).anyMatch(number -> Integer.parseInt(number) > MAX_LOTTO_NUMBER)){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_WINNING_NUMBER.getErrorMessage());
        }

        return lastWinningNumbers;
    }

    public int validateBonusNumber(String bonusNumberValue) {
        if (!bonusNumberValue.matches(BONUS_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
        }
        int bonusNumber = Integer.parseInt(bonusNumberValue);
        if(bonusNumber> MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_BONUS_NUMBER.getErrorMessage());
        }

        return bonusNumber;
    }

    private String[] splitWinningNumber(String lastWinningNumbersInput) {
        return lastWinningNumbersInput.split(WINNING_NUMBER_DELIMITER);
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

