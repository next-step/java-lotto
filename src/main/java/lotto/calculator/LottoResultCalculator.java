package lotto.calculator;

import lotto.winningnumber.WinningNumber;
import lotto.result.LottoResult;
import lotto.ticket.LottoTicket;

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

    public Map<LottoResult, Integer> calculateResult() {
        Map<LottoResult, Integer> lottoResults = initLottoResult();
        lottoTickets.forEach(lottoTicket -> {
            LottoResult result = new LottoResult(winningNumber.matchLottoNumbers(lottoTicket));
            lottoResults.put(result, lottoResults.getOrDefault(result, DEFAULT_MATCHED_LOTTO_NUMBER_COUNT) + LOTTO_NUMBER_HIT);
        });
        return lottoResults;
    }

    private Map<LottoResult, Integer> initLottoResult() {
        Map<LottoResult, Integer> lottoResults = new TreeMap<>();
        for (int numberOfMatched = 0; numberOfMatched <= LottoTicket.NUMBER_OF_LOTTO_NUMBERS; numberOfMatched++) {
            lottoResults.put(new LottoResult(numberOfMatched), DEFAULT_MATCHED_LOTTO_NUMBER_COUNT);
        }
        return lottoResults;
    }

}
