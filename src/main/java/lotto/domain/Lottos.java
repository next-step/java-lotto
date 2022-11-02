package lotto.domain;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;

import java.util.List;

public class Lottos {

    public static final int SECOND_PLACE_CORRECT_COUNT = 5;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosAmount(){
        return lottos.size();
    }

    public RewardStatistics match(WinningLotto winningLotto) {
        RewardStatistics rewardStatistics = new RewardStatistics();
        lottos.forEach(lotto -> {
            int sameSize = lotto.getSameElementsSize(winningLotto.getWinningLotto());
            boolean correctBonus = lotto.hasSameElement(winningLotto.getBonusWinningNumber());
            boolean needBonus = sameSize == SECOND_PLACE_CORRECT_COUNT;
            rewardStatistics.plusCount(WinnerRank.valueOf(new WinnerRankCondition(sameSize, needBonus && correctBonus)));
        });
        return rewardStatistics;
    }

    public void addAll(List<Lotto> lottos){
        this.lottos.addAll(lottos);
    }
}
