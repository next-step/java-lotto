package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lotto;
    private int count = 0;


    public Lotto(List<Integer> lotto){
        if (lotto.size()!=6) {
            throw new IllegalArgumentException("로또는 6개 원소 필요");
        }

        if (lotto.size() != lotto.stream().distinct().count()) {
            throw new IllegalArgumentException("로또는 원소 중복 불가");
        }

        this.lotto = new LottoNumbers(lotto);
    }



    public RankMatches numMatch(Lotto pickedLotto, BonusNum pickedBouns){
        for (int element: pickedLotto.getLottoList()) {
            checkMatch(element);
        }

        return RankMatches.makeRank(count, this.lotto.lottoContains(pickedBouns.getBonusNum()));
    }

    private void checkMatch(int element) {
        if (this.lotto.lottoContains(element)) {
            this.count = this.count + 1;
        }
    }

    public List<Integer> getLottoList() {
        return lotto.getLotto();
    }
}
