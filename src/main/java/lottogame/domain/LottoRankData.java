package lottogame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRankData implements CountWinnerStrategy {
    FORTH_WINNER(5_000, 3, () -> getCountWinner(3)),
    THIRD_WINNER(50_000, 4, () -> getCountWinner(4)),
    SECOND_WINNER(1_500_000, 5, () -> getCountWinner(5)),
    BONUS_SECOND_WINNER(3_000_0000, 5, () -> getCountWinner(1)),
    FIRST_WINNER(2_000_000_000, 6, () -> getCountWinner(6));

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
        double totalRevenue = Arrays.stream(LottoRankData.values())
                .mapToDouble(data -> data.getCountWinner(data.match) * data.getPrize()).sum();
        return totalRevenue;
    }

    public static List<WinnerGroupDTO> makeWinnersGroup() {
        List<WinnerGroupDTO> winnerGroup = Arrays.stream(LottoRankData.values())
                .map(data -> new WinnerGroupDTO(data.getMatch(), data.getPrize(), (int) data.getCountWinner(data.match)))
                .collect(Collectors.toList());
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



