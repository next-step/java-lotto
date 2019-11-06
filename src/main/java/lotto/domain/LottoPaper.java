package lotto.domain;

import lotto.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoPaper {
    private static final int BONUS_CHECK = 1;
    private static final int SECOND_LOTTO_WIN_COUNT = 2;

    private List<Lotto> lottoPapers;

    public LottoPaper() {
        this.lottoPapers = new ArrayList<>();
    }

    public LottoPaper(Integer count) {
        this.lottoPapers = new ArrayList<>();
        createLotto(count);
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }

    private void createLotto(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            applyLotto(lotto);
        }
    }

    public void applyLotto(Lotto lotto) {
        this.lottoPapers.add(lotto);
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
