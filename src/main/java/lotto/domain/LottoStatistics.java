package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {

    private final WinningNumbers winningNumbers;
    private final LottoTicket lottoTicket;
    private final List<PrizeGrade> lottoTicketResult;
    private final HashMap<PrizeGrade, Integer> resultStatistics;

    public LottoStatistics(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        this.winningNumbers = winningNumbers;
        this.lottoTicket = lottoTicket;
        this.lottoTicketResult = calculateLottoTicketResult();
        this.resultStatistics = new HashMap<>();

        initResultStatistics();
        calculateResult();
    }

    public static LottoStatistics of(WinningNumbers winningNumbers,
        LottoTicket lottoTicket) {
        return new LottoStatistics(winningNumbers, lottoTicket);
    }

    public Map<PrizeGrade, Integer> getResultStatistics() {
        return Collections.unmodifiableMap(resultStatistics);
    }

    public double getLottoEarningRate() {
        double totalPrice = lottoTicketResult.stream()
            .mapToInt(PrizeGrade::getPrizeMoney)
            .sum();

        return totalPrice / lottoTicket.getPrice();
    }

    private void initResultStatistics() {
        Arrays.stream(PrizeGrade.values())
            .forEach(prizeGrade -> resultStatistics.put(prizeGrade, 0));
    }

    private void calculateResult() {
        lottoTicketResult.forEach(prizeGrade -> {
            if (resultStatistics.containsKey(prizeGrade)) {
                int prizeGradeCount = resultStatistics.get(prizeGrade);

                resultStatistics.put(prizeGrade, prizeGradeCount + 1);
                return;
            }
            resultStatistics.put(prizeGrade, 1);
        });
    }

    private List<PrizeGrade> calculateLottoTicketResult() {
        return lottoTicket.getLottoList().stream()
            .map(x -> PrizeGrade.of(getMatchCount(x), isBonusMatch(x)))
            .collect(Collectors.toList());
    }

    private int getMatchCount(final Lotto lotto) {
        return (int) lotto.getLotto().stream()
            .filter(winningNumbers::isWinningNumbersContain)
            .count();
    }

    private boolean isBonusMatch(final Lotto lotto) {
        return lotto.getLotto().stream()
            .anyMatch(winningNumbers::isBonusNumberEqualTo);
    }
}
