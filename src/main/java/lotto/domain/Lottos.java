package lotto.domain;

import lotto.dto.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> value;

    private Lottos(List<Lotto> value) {
        this.value = value;
    }

    public static Lottos of(List<Lotto> value) {
        return new Lottos(value);
    }

    public int size() {
        return value.size();
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public List<WinningRank> getWinningRanks(WinningNumber winningNumber) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto boughtLotto : value) {
            winningRanks.add(WinningRank.getWinningRank(winningNumber, boughtLotto));
        }
        return winningRanks;
    }

    public void labelNumbers(Consumer<Set<LottoNumber>> consumer) {
        for (Lotto lotto : value) {
            consumer.accept(lotto.getNumbers());
        }
    }
}
