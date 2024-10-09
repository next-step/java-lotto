package lotto.result;

import lotto.ticket.LottoTicket;
import lotto.game.WinningNumber;

import java.util.*;

import static lotto.ticket.LottoTicket.NUMBER_OF_LOTTO_NUMBERS;

public class LottoResultStatistics {
    private static final int DEFAULT_MATCHED_LOTTO_NUMBER_COUNT = 0;
    private static final int LOTTO_NUMBER_HIT = 1;

    private final List<LottoTicket> lottoTickets;
    private final WinningNumber winningNumber;
    private final Map<LottoResult, Integer> lottoResults = new TreeMap<>();

    public LottoResultStatistics(List<LottoTicket> lottoTickets, WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumber = winningNumber;
        initLottoResult();
    }

    public Map<LottoResult, Integer> calculateResult() {
        lottoTickets.forEach(lottoTicket ->
                addLottoResult(new LottoResult(winningNumber.matchLottoNumbers(lottoTicket))));
        return lottoResults;
    }

    private void initLottoResult() {
        for (int numberOfMatched = 0; numberOfMatched <= NUMBER_OF_LOTTO_NUMBERS; numberOfMatched++) {
            lottoResults.put(new LottoResult(numberOfMatched), DEFAULT_MATCHED_LOTTO_NUMBER_COUNT);
        }
    }

    private void addLottoResult(LottoResult lottoResult) {
        Integer matchedNumberCount = lottoResults.getOrDefault(lottoResult, DEFAULT_MATCHED_LOTTO_NUMBER_COUNT);
        lottoResults.put(lottoResult, matchedNumberCount + LOTTO_NUMBER_HIT);
    }
}
