package step2;

import step2.vo.LottoResults;

import java.util.List;

public enum LottoRank {

    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000);

    private static final int LOTTO_PER_PRICE = 1000;

    private static final int INIT_WINNER = 0;

    private final int countOfMatch;

    private final long prizeAmount;

    private int numOfWinner;

    LottoRank(int countOfMatch, long prizeAmount) {
        this.countOfMatch = countOfMatch;
        this.prizeAmount = prizeAmount;
        this.numOfWinner = INIT_WINNER;
    }

    public static void electWinner(List<Integer> winNumbers, LottoResults lottoResults) {
        List<Integer> numOfWinner = lottoResults.countNumOfWinner(winNumbers);
        for (Integer countWinner : numOfWinner) {
            addCountOfMatch(countWinner);
        }
    }

    private static void addCountOfMatch(Integer countWinner) {
        if (countWinner == MATCH_THREE.countOfMatch) {
            MATCH_THREE.numOfWinner++;
        }
        if (countWinner == MATCH_FOUR.countOfMatch) {
            MATCH_FOUR.numOfWinner++;
        }
        if (countWinner == MATCH_FIVE.countOfMatch) {
            MATCH_FIVE.numOfWinner++;
        }
        if (countWinner == MATCH_SIX.countOfMatch) {
            MATCH_SIX.numOfWinner++;
        }
    }

    public static double calculatorRateOfReturn(int numOfLottoTicket) {
        return (((MATCH_THREE.numOfWinner * MATCH_THREE.prizeAmount)
                + (MATCH_FOUR.numOfWinner * MATCH_FOUR.prizeAmount)
                + (MATCH_FIVE.numOfWinner * MATCH_FIVE.prizeAmount)
                + (MATCH_SIX.numOfWinner * MATCH_SIX.prizeAmount))
                / numOfLottoTicket) * LOTTO_PER_PRICE;
    }

    /**
     * * ResultView 의존성을 끊어내기 위한 Getter. 이 외 사용금지.
     *
     * @return 각 등 수에 맞는 우승자 수.
     */
    public int numOfWinner() {
        return this.numOfWinner;
    }
}
