package step4.domain.winning;

import step3.domain.winning.WinningStatus;
import step4.domain.lotto.Lotto;
import step4.domain.rank.Rank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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
        return null;
    }

}
