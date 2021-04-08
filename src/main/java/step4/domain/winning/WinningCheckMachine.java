package step4.domain.winning;

import step4.domain.lotto.Lotto;
import step4.domain.rank.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class WinningCheckMachine {

    private static class WinningCheckMachineHolder {
        private static WinningCheckMachine instance = new WinningCheckMachine();
    }

    private WinningCheckMachine() {
    }

    public static final WinningCheckMachine getInstance() {
        return WinningCheckMachineHolder.instance;
    }

    public final WinningResult checkUserLottoAndWinningLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        TreeMap<Rank, Long> winningMap = lottos.stream()
                .map(winningLotto::getWinningStatus)
                .map(Rank::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

        Arrays.stream(Rank.values())
                .filter(rank -> winningMap.get(rank) == null)
                .forEach(rank -> winningMap.put(rank, 0L));

        return WinningResult.of(winningMap);
    }

}
