package domain;

import java.util.List;

public class WinningLottoGroup {
    List<WinningLotto> winningLottoGroup;

    public WinningLottoGroup(List<WinningLotto> winningLottoGroup) {
        this.winningLottoGroup = winningLottoGroup;
    }

    public int getSize() {
        return winningLottoGroup.size();
    }

    public boolean isContain(Lotto lotto) {
        return winningLottoGroup.stream().
                anyMatch(obj -> obj.equals(lotto));
    }

    public int getTotalReward() {
        int sum = 0;
        for (WinningLotto winningLotto : winningLottoGroup) {
            sum += winningLotto.getReward();
        }
        return sum;
    }

    public int getCombineNumbers(LottoRank rank) {
        return (int) winningLottoGroup.stream()
                .filter(obj -> obj.getCombineLotto(rank.getCombineNum(), rank.equals(LottoRank.SECOND_PRICE))).count();
    }


}
