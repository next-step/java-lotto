package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LottoWinningCalculator {
    private static final int THIRD = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private Lotto winner;
    private List<Lotto> myLotto;
    private HashMap<Integer, Integer> prizeMap;

    LottoWinningCalculator(Lotto winner, List<Lotto> myLotto) {
        this.winner = winner;
        this.myLotto = myLotto;
        initializePrizeMap();
    }

    public HashMap<Integer, Integer> countPrizeMap() {
        for (Lotto lotto : myLotto) {
            int count = winner.correctCount(lotto);
            prizeMap.computeIfPresent(count,  (_k, v) -> v + 1);
        }

        return prizeMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningCalculator that = (LottoWinningCalculator) o;
        return Objects.equals(winner, that.winner) && Objects.equals(myLotto, that.myLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winner, myLotto);
    }

    @Override
    public String toString() {
        return "LottoWinningCalculator{" +
                "winner=" + winner +
                ", myLotto=" + myLotto +
                '}';
    }

    private void initializePrizeMap() {
        prizeMap = new HashMap<>();
        prizeMap.put(THIRD, 0);
        prizeMap.put(FOUR, 0);
        prizeMap.put(FIVE, 0);
        prizeMap.put(SIX, 0);
    }
}
