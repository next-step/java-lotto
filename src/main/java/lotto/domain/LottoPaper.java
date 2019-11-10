package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private static final int BONUS_CHECK = 1;
    private static final int SECOND_LOTTO_WIN_COUNT = 2;

    private List<Lotto> lottoPapers;

    public LottoPaper(Integer count, LottosGenerator lottosGenerator) {
        this.lottoPapers = lottosGenerator.generate(count);
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }

    public List<Rank> getWinningLottoRanks(int[] winLotto, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottoPapers) {
            int winNumberCount = lotto.checkWinNumber(winLotto);

            if (winNumberCount == SECOND_LOTTO_WIN_COUNT) {
                int getBonusNumber = lotto.getHitCount(bonusNumber);
                if (getBonusNumber == BONUS_CHECK) {
                    ranks.add(Rank.valueOf(winNumberCount, true));
                }
            }
            ranks.add(Rank.valueOf(winNumberCount, false));
        }
        return ranks;
    }
}
