package lotto.domain;

import lotto.common.type.WinnerRank;
import lotto.common.type.WinnerRankCondition;
import lotto.service.Reward;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoSize) {
        while (lottos.size() < lottoSize) {
            lottos.add(Lotto.generateRandomLotto());
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
            boolean correctBonus = getCorrectBonus(winningLotto.getBonusWinningNumber(), lotto, sameSize);
            reward.plusCount(WinnerRank.valueOf(WinnerRankCondition.missCountFrom(sameSize, correctBonus)));
        });
        return reward;
    }

    private boolean getCorrectBonus(int bonusNumber, Lotto lotto, int sameSize) {
        return sameSize == SECOND_PLACE_CORRECT_COUNT && lotto.hasSameElement(bonusNumber);
    }
}
