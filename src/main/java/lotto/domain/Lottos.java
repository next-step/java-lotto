package lotto.domain;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import lotto.strategy.LottoRandomGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoSize) {
        while (lottos.size() < lottoSize) {
            lottos.add(new Lotto(new LottoRandomGenerateStrategy()));
        }
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosAmount(){
        return lottos.size();
    }

    public static final int SECOND_PLACE_CORRECT_COUNT = 5;

    public Reward countWinningNumbers(WinningLotto winningLotto) {
        Reward reward = new Reward();
        lottos.forEach(lotto -> {
            int sameSize = lotto.getSameElementsSize(winningLotto.getWinningLotto());
            boolean correctBonus = lotto.hasSameElement(winningLotto.getBonusWinningNumber());
            boolean needBonus = sameSize == SECOND_PLACE_CORRECT_COUNT;
            reward.plusCount(WinnerRank.valueOf(new WinnerRankCondition(sameSize, needBonus && correctBonus)));
        });
        return reward;
    }
}
