package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(Money money) {
        this(buyLotto(money));
    }

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    private static List<Lotto> buyLotto(Money money) {
        int cnt = money.getBuyableCount();

        List<Lotto> lottoArray = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }

    public LottoResult match(LottoWinningNumbers winLottoWinningNumbers) {
        return calculate(winLottoWinningNumbers);
    }

    private LottoResult calculate(LottoWinningNumbers winLottoWinningNumbers) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : this.lottos) {
            LottoRank rank = winLottoWinningNumbers.determineRank(lotto);

            lottoResult.rank(rank);
        }

        return lottoResult;
    }
}
