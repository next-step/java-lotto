package lotto.calculator;

import lotto.ticket.LottoTicket;
import lotto.winningnumber.WinningNumber;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResultCalculator {
    private static final int DEFAULT_MATCHED_LOTTO_NUMBER_COUNT = 0;
    private static final int LOTTO_NUMBER_HIT = 1;

    private final List<LottoTicket> lottoTickets;
    private final WinningNumber winningNumber;

    public LottoResultCalculator(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumber = winningNumber;
    }

    public Map<Integer, Integer> calculateResult() {
        Map<Integer, Integer> lottoResults = initLottoResult();
        lottoTickets.forEach(lottoTicket -> {
            int matchedLottoNumbersCount = winningNumber.matchLottoNumbers(lottoTicket);
            lottoResults.put(matchedLottoNumbersCount, lottoResults.getOrDefault(matchedLottoNumbersCount, DEFAULT_MATCHED_LOTTO_NUMBER_COUNT) + LOTTO_NUMBER_HIT);
        });
        return lottoResults;
    }

    private Map<Integer, Integer> initLottoResult() {
        Map<Integer, Integer> lottoResults = new TreeMap<>();
        for (int numberOfMatched = 0; numberOfMatched <= LottoTicket.NUMBER_OF_LOTTO_NUMBERS; numberOfMatched++) {
            lottoResults.put(numberOfMatched, DEFAULT_MATCHED_LOTTO_NUMBER_COUNT);
        }
        return lottoResults;
    }

}
