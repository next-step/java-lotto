package lotto.domain2;

import java.util.Objects;

public class WinningLottos {
    private final Lottos winningLottos;

    public WinningLottos(final Lottos winningLottos) {
        this.winningLottos = winningLottos;
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
