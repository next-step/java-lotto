package lottogame.domain;

import java.util.ArrayList;
import java.util.List;

public enum LottoRankData implements CountWinnerStrategy {
    FIRST_WINNER(2_000_000_000, 6, () -> getCountWinner(6)),

    SECOND_WINNER(1_500_000, 5, () -> getCountWinner(5)),

    THIRD_WINNER(50_000, 4, () -> getCountWinner(4)),

    FORTH_WINNER(5_000, 3, () -> getCountWinner(3)),

    BONUS_SECOND_WINNER(3_000_0000, 5, () -> getCountWinner(1));

    private final static int BONUS_MATCH = 1;

    private int prize, match;
    private static int bonusBallCount;
    static List<Integer> countsOfWinningResultConvertList;
    private CountWinnerStrategy countWinnerStrategy;

    private LottoRankData(int prize, int match, final CountWinnerStrategy countWinnerStrategy) {
        this.prize = prize;
        this.match = match;
        this.countWinnerStrategy = countWinnerStrategy;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }

    public static void setBonusBallCount(int count) {
        bonusBallCount = count;
    }

    public static void setCountsOfWinningResultConvertList(List<Integer> result) {
        countsOfWinningResultConvertList = result;
    }

    public static double calculatorTotalWinningRevenue() {
        return (FIRST_WINNER.getCountWinner(FIRST_WINNER.match) * FIRST_WINNER.getPrize()) + (SECOND_WINNER.getCountWinner(SECOND_WINNER.match) * SECOND_WINNER.getPrize())
                + (THIRD_WINNER.getCountWinner(THIRD_WINNER.match) * THIRD_WINNER.getPrize()) + (FORTH_WINNER.getCountWinner(FORTH_WINNER.match) * FORTH_WINNER.getPrize())
                + (BONUS_SECOND_WINNER.getCountWinner(BONUS_MATCH) * BONUS_SECOND_WINNER.getPrize());
    }

    public static List<WinnerGroupDTO> makeWinnersGroup() {
        List<WinnerGroupDTO> winnerGroup = new ArrayList<>();
        winnerGroup.add(new WinnerGroupDTO(FORTH_WINNER.getMatch(), FORTH_WINNER.getPrize(), (int) FORTH_WINNER.getCountWinner(FORTH_WINNER.match)));
        winnerGroup.add(new WinnerGroupDTO(THIRD_WINNER.getMatch(), THIRD_WINNER.getPrize(), (int) THIRD_WINNER.getCountWinner(THIRD_WINNER.match)));
        winnerGroup.add(new WinnerGroupDTO(SECOND_WINNER.getMatch(), SECOND_WINNER.getPrize(), (int) SECOND_WINNER.getCountWinner(SECOND_WINNER.match)));
        winnerGroup.add(new WinnerGroupDTO(BONUS_SECOND_WINNER.getMatch(), BONUS_SECOND_WINNER.getPrize(), (int) BONUS_SECOND_WINNER.getCountWinner(BONUS_MATCH)));
        winnerGroup.add(new WinnerGroupDTO(FIRST_WINNER.getMatch(), FIRST_WINNER.getPrize(), (int) FIRST_WINNER.getCountWinner(FIRST_WINNER.match)));

        return winnerGroup;
    }

    private static long getCountWinner(int match) {
        if (match == BONUS_MATCH) {
            return bonusBallCount;
        }
        return countsOfWinningResultConvertList.stream().filter(x -> x.equals(match)).count();
    }

    @Override
    public long getCountWinner() {
        return countWinnerStrategy.getCountWinner();
    }
}



