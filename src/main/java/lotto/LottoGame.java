package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;
    private LottoGenerator lottoGenerator;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> buy(int money) {
        int tickets = money / LOTTO_PRICE;

        for (int i = 0; i < tickets; i++) {
            lottos.add(new Lotto(lottoGenerator.generate()));
        }
        return lottos;
    }

    public LottoResult checkLuckyCount(Lotto luckyNumbers) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            lottoResult.addMatchCount(lotto.matchNumbers(luckyNumbers));
        }
        return lottoResult;
    }
}
