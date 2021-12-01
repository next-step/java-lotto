package lotto.domain;

import java.util.List;

public class LottoScore extends Lotto {

    private Rank rank;

    public LottoScore(List<Integer> numList, WinningLotto winningLotto) {
        super(numList);
        getRank(winningLotto);
    }

    private void getRank(WinningLotto winningLotto) {
        int count = Math.toIntExact(lottoNumList.stream().filter(winningLotto.lottoNumList::contains).count());
        boolean bonus = lottoNumList.contains(winningLotto.getBonusNum());

        this.rank = Rank.valueOf(count, bonus);
    }

    public Rank getRank() {
        return rank;
    }
}
