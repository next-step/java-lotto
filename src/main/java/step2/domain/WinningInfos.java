package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningInfos {

    private List<WinningInfo> winningInfoList = new ArrayList<>();


    public List<WinningInfo> winningInfoList() {
        return winningInfoList;
    }

    public void addWinningInfo(WinningInfo winningInfo) {
        this.winningInfoList.add(winningInfo);
    }

    public void removeWinningInfo(WinningInfo winningInfo) {
        this.winningInfoList.remove(winningInfo);
    }

    public int earningMoney() {
        return this.winningInfoList.stream()
                .mapToInt(WinningInfo::earningMoney)
                .sum();
    }
}
