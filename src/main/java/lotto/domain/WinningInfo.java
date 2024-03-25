package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningInfo {

    private final Map<Rank, Integer> winningInfo;

    private WinningInfo(Map<Rank, Integer> winningInfo) {
        this.winningInfo = winningInfo;
    }

    public static WinningInfo of(Lottos lottos, LottoNumber bonusNumber, Lotto winningLotto) {
        HashMap<Rank, Integer> winningInfo = new HashMap<>();

        for (Lotto pickedNumber : lottos) {
            int matchCount = compareLottoNumbers(pickedNumber, winningLotto);
            boolean matchBonus = containBonusNumber(winningLotto, bonusNumber);

            Rank rank = Rank.findRank(matchCount, matchBonus);
            winningInfo.put(rank, winningInfo.getOrDefault(rank, 0) + 1);
        }
        return new WinningInfo(winningInfo);
    }

    private static boolean containBonusNumber(Lotto pickedLotto, LottoNumber bonusNumber) {
        return pickedLotto.containBonusNumber(bonusNumber);
    }

    private static int compareLottoNumbers(Lotto pickedLotto, Lotto winningLotto) {
        return pickedLotto.compare(winningLotto);
    }

    public int totalWinningMoney() {
        int totalWinningMoney = 0;
        for (Rank rank : winningInfo.keySet()) {
            totalWinningMoney += (rank.getWinningMoney() * this.count(rank));
        }
        return totalWinningMoney;
    }

    public int count(Rank rank) {
        return winningInfo.getOrDefault(rank, 0);
    }
}
