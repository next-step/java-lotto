package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoStatistics {

    private static final int TWO_DECIMAL = 2;
    private static final int COUNT = 1;
    private static final int MATCH_DEFAULT_COUNT = 0;
    private static final int MATCH_NUMBER_FIVE_CHECK = 5;
    private int matchCheckNumber;
    private final Map<WinnerAmount, Integer> matchResult = new LinkedHashMap<>();

    public double rateOfReturn(int winningAmount, int purchaseAmount) {
         return BigDecimal.valueOf((double) winningAmount / (double) purchaseAmount).setScale(TWO_DECIMAL,RoundingMode.DOWN).doubleValue();
    }

    private void matchResultInit() {
        Arrays.stream(WinnerAmount.values())
            .forEach(winnerAmount -> matchResult.put(winnerAmount, MATCH_DEFAULT_COUNT));
    }

    public void confirmOfLottoNumber(Lottos lottos, LottoWinnerNumber lottoWinnerNumber) {
        matchResultInit();

        lottos.getLottoList().stream()
                .map(Lotto::getNumbers)
                .forEach(numbers -> matchWinnerAmount(lottoWinnerNumber, numbers));
    }

    private void matchWinnerAmount(LottoWinnerNumber lottoWinnerNumber, List<Number> numbers) {
        matchCheckNumber = matchLottoNumberCheck(lottoWinnerNumber, numbers);
        if(matchCheckNumber == MATCH_NUMBER_FIVE_CHECK && lottoWinnerNumber.bonusNumberContains(numbers)) {
            mapCount(WinnerAmount.matchSecond());
        }
        mapCount(WinnerAmount.matchCheck(matchCheckNumber));
    }

    private void mapCount(WinnerAmount winnerAmountObject) {
        matchResult.put(winnerAmountObject, matchResult.get(winnerAmountObject) + COUNT);
    }

    private int matchLottoNumberCheck(LottoWinnerNumber lottoWinnerNumber, List<Number> numbers) {
        return (int) numbers.stream().filter(lottoWinnerNumber::validateContainsNumber).count();
    }

    public Map<WinnerAmount, Integer> getMatchResult() {
        return matchResult;
    }
}
