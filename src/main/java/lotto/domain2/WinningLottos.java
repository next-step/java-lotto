package lotto.domain2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningLottos {
    private static final int OPERAND_FOR_FLOOR = 100;
    private static final double OPERAND_FOR_TRANSLATE_DOUBLE = 100.0;
    private List<WinningLotto> winningLottos;

    public WinningLottos() {
        this.winningLottos = new ArrayList<>();
    }

    void addOnlyWinning(final Lotto lotto, final Rank rank) {
        if (rank != Rank.LOSE) {
            this.winningLottos.add(new WinningLotto(lotto, rank));
        }
    }

    public int getCountOf(final Rank rank) {
        return (int) winningLottos.stream()
                .filter(winningLotto -> winningLotto.is(rank))
                .count();
    }

    public double getRate(final int money) {
        final double winningMoney = winningLottos.stream()
                .mapToDouble(WinningLotto::getWinningMoney)
                .sum();

        return Math.floor(winningMoney / money * OPERAND_FOR_FLOOR) / OPERAND_FOR_TRANSLATE_DOUBLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottos that = (WinningLottos) o;
        return Objects.equals(winningLottos, that.winningLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottos);
    }
}
