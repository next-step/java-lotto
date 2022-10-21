package lotto.domain;

public class Rank {
    private final RankMap rankMap;

    public Rank() {
        this.rankMap = new RankMap();
    }

    public Integer findRank(Prize prize) {
        return rankMap.getCount(prize).getCount();
    }

    public void settingRank(int matchingCount, boolean containBonusNumber) {
        addRankMap(Prize.findPrize(matchingCount, containBonusNumber));
    }

    private void addRankMap(Prize prize) {
        RankCount rankCount = rankMap.getCount(prize);
        rankMap.putCount(prize, rankCount.rankCountPlusOne());
    }
}
