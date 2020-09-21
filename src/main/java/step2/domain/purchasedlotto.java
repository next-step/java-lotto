package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class purchasedlotto {

    private List<Lotto> purChasedLotto;
    private Map<Rank, Integer> rankInfo = Rank.getInitRankInfo();

    public purchasedlotto(List<Lotto> purChasedLotto) {
        this.purChasedLotto = purChasedLotto;
    }

    public purchasedlotto(List<Lotto> nonAutoLottoList, List<Lotto> autoLottoList) {
        List<Lotto> purChasedLotto = Stream.concat(nonAutoLottoList.stream(), autoLottoList.stream())
                .collect(Collectors.toList());
        this.purChasedLotto = purChasedLotto;
    }

    public void matchNumber(WinningLotto winningLotto) {
        for (Lotto lotto : purChasedLotto) {
            updateRankInfo(winningLotto.match(lotto));
        }
    }

    public Map<Rank, Integer> getRankInfo() {
        return rankInfo;
    }

    public int getTotalPrize() {
        return rankInfo.keySet().stream()
                .mapToInt((rank) -> rank.getPrize() * rankInfo.get(rank))
                .reduce((prize1, prize2) -> prize1 + prize2)
                .getAsInt();
    }

    private void updateRankInfo(Rank rank) {
        if (rankInfo.containsKey(rank)) {
            rankInfo.replace(rank, rankInfo.get(rank) + 1);
        }
    }
}
