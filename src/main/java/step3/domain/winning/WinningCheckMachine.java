package step3.domain.winning;

import step3.domain.lotto.BonusLottoNumber;
import step3.domain.lotto.Lotto;
import step3.domain.rank.Rank;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class WinningCheckMachine {

    private static class WinningCheckMachineHolder {
        public static final WinningCheckMachine instance = new WinningCheckMachine();
    }

    private WinningCheckMachine() {
    }

    public static final WinningCheckMachine getInstance() {
        return WinningCheckMachineHolder.instance;
    }

    public WinningResult getWinningResult(List<Lotto> lottos, Lotto winningLotto, BonusLottoNumber bonusLottoNumber) {
        Map<Rank, Integer> winningScoreIntegerMap = new TreeMap<>();
        for(Lotto lotto: lottos) {
            int countOfMatch =  winningLotto.getCountOfMatch(lotto);
            boolean matchBonus = bonusLottoNumber.isIncludeByLotto(lotto);
            Rank rank = Rank.valueOf(countOfMatch, matchBonus);
            winningScoreIntegerMap.put(rank, winningScoreIntegerMap.get(rank)+1);
        }
        return WinningResult.of(winningScoreIntegerMap);
    }

}
