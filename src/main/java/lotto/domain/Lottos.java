package lotto.domain;

import java.util.*;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int lottosSize() {
        return this.lottoList.size();
    }

    public LottoResults getResult(Lotto winning, LottoNumber bonus) {
        LottoResults lottoResults = new LottoResults();
        for (Lotto lotto : lottoList) {
            int sameNumbers = lotto.getSameNumberCount(winning);
            boolean winBonus = lotto.getLottoNumbers().contains(bonus);

            Rank rank = Rank.valueOf(sameNumbers, winBonus);
            lottoResults.addRank(rank);
        }
        return lottoResults;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public Lottos createAutoLottos(int amount) {
        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottoList.add(new Lotto());
        }
        return this;
    }

    public Lottos createManualLottos(List<String> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            this.lottoList.add(new Lotto(numbers.get(i)));
        }
        return this;
    }


}
