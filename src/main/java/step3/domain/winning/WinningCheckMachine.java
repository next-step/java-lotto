package step3.domain.winning;

import step3.domain.lotto.Lotto;
import step3.domain.rank.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class WinningCheckMachine {

    private static final int ZERO = 0;
    private static final int INCREASE = 1;

    private static class WinningCheckMachineHolder {
        public static final WinningCheckMachine instance = new WinningCheckMachine();
    }

    private WinningCheckMachine() {
    }

    public static final WinningCheckMachine getInstance() {
        return WinningCheckMachineHolder.instance;
    }

    public final WinningResult getWinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> winningResultMap = generateAndInitWinningMap();
        lottos.stream()
                .map(winningLotto::getWinningStatus)
                .map(Rank::valueOf)
                .forEach(rank -> winningResultMap.put(rank, winningResultMap.get(rank)+INCREASE));
        return WinningResult.of(winningResultMap);
    }

    private final Map<Rank, Integer> generateAndInitWinningMap() {
        Map<Rank, Integer> winningMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningMap.put(rank, ZERO);
        }
        return winningMap;
    }

}
