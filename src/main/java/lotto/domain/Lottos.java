package lotto.domain;

import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.*;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private NumberGenerator numberGenerator = new RandomNumberGenerator();

    private List<Lotto> lottoList;

    public Lottos(int amount) {
        this.lottoList = new ArrayList<>();

        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottoList.add(new Lotto(numberGenerator));
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int lottosSize() {
        return this.lottoList.size();
    }

    public RankMap getResult(Lotto winning, LottoNumber bonus) {
        RankMap rankMap = new RankMap();
        for (Lotto lotto : lottoList) {
            int sameNumbers = lotto.getSameNumberCount(winning);
            boolean winBonus = lotto.getLottoNumbers().contains(bonus);

            Rank rank = Rank.valueOf(sameNumbers, winBonus);
            rankMap.addRank(rank);
        }
        return rankMap;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

}
