package step2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTotalCalculator {
    private final String EXCEPTION_NOTSIX_NUMBER = "당첨 숫자는 중복되지 않은 6개만 입력 가능합니다.";
    private final String EXCEPTION_OVER_NUMBER = "당첨 숫자는 1~45만 가능합니다.";

    private final int PERCENTAGE = 100;

    private final static int MIN = 1;
    private final static int MAX = 45;
    private final static int SIZE = 6;

    private Map<WinnerTier, Integer> WinningResult = new HashMap<>();

    public Map<WinnerTier, Integer> countWinners(LottoGame lottoGame, List<Integer> WinnerNumbers) {

        checkValidationWinerNumbers(WinnerNumbers);

        for (WinnerTier winnerTier : WinnerTier.values()) {
            long matchCount = lottoGame.getLottos().stream()
                    .filter(lotto -> lotto.checkWinningCount(WinnerNumbers) == winnerTier.getMatchCnt())
                    .count();

            WinningResult.put(winnerTier, (int) matchCount);
        }

        return WinningResult;
    }

    public double returnYield(int lottoMoney) {
        double sum = 0;

        for (WinnerTier winnerTier : WinnerTier.values()) {
            sum += winnerTier.getPrize() * WinningResult.get(winnerTier);
        }

        return Math.floor(sum / lottoMoney * 100) / 100;
    }

    public void checkValidationWinerNumbers(List<Integer> WinnerNumbers) {
        int cnt = (int) WinnerNumbers.stream()
                .distinct()
                .count();

        if (cnt != SIZE) {
            throw new IllegalArgumentException(EXCEPTION_NOTSIX_NUMBER);
        }

        for (Integer number : WinnerNumbers) {
            if (number > MAX || number < MIN) {
                throw new IllegalArgumentException(EXCEPTION_OVER_NUMBER);
            }
        }
    }
}
