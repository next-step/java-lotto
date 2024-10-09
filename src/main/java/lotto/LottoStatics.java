package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoStatics {

    private static final int THREE_PRIZE = 5_000;
    private static final int FOUR_PRIZE = 50_000;
    private static final int FIVE_PRIZE = 1_500_000;
    private static final int WIN_PRIZE = 2_000_000_000;

    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStatics() {
    }

    public LottoStatics(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int match(List<Integer> winnerNumber, int matchNumber) {
        int result = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(winnerNumber, lotto);
            result = isMatch(matchNumber, matchCount) ? result + 1 : result;
        }

        return result;
    }

    public double calculateRatio(List<Integer> winnerNumber, int money) {
        int totalPrize = 0;

        totalPrize += match(winnerNumber, 3) * THREE_PRIZE;
        totalPrize += match(winnerNumber, 4) * FOUR_PRIZE;
        totalPrize += match(winnerNumber, 5) * FIVE_PRIZE;
        totalPrize += match(winnerNumber, 6) * WIN_PRIZE;

        double ratio = (double)totalPrize / money;

        return Math.floor(ratio * 100) / 100.0;
    }

    private static boolean isMatch(int matchNumber, int matchCount) {
        if (matchCount == matchNumber) {
            return true;
        }
        return false;
    }

    private static int getMatchCount(List<Integer> winnerNumber, Lotto lotto) {
        int count = 0;
        for (int number : lotto.getLottoNumbers()) {
            count = isContain(winnerNumber, number) ? count + 1 : count;
        }
        return count;
    }

    private static boolean isContain(List<Integer> winnerNumber, int number) {
        if (winnerNumber.contains(number)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoStatics))
            return false;
        LottoStatics that = (LottoStatics)o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
