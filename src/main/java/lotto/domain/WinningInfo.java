package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningInfo {

    private final Map<Rank, Integer> winningInfo;

    private WinningInfo(Map<Rank, Integer> winningInfo) {
        this.winningInfo = winningInfo;
    }

    public static WinningInfo of(PickedLottoNumbers pickedLottoNumbers, LottoNumbers winningNumbers) {
        HashMap<Rank, Integer> winningInfo = new HashMap<>();
        for (LottoNumbers pickedNumber : pickedLottoNumbers) {
            Rank rank = Rank.findRank(countNumber(pickedNumber, winningNumbers));
            winningInfo.put(rank, winningInfo.getOrDefault(rank, 0) + 1);
        }
        return new WinningInfo(winningInfo);
    }

    private static int countNumber(LottoNumbers pickedNumber, LottoNumbers winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += pickedNumber.contains(winningNumber);
        }
        return matchCount;
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
