package lotto;

import lotto.domain.LuckyLotto;
import lotto.domain.MyLotto;
import lotto.util.LottoBasicNumber;
import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private List<MyLotto> myLottos;
    private LottoGenerator lottoGenerator;

    public LottoGame() {
        this.myLottos = new ArrayList<>();
        this.lottoGenerator = new LottoGenerator();
    }

    public LottoGame(List<MyLotto> myLottos) {
        this.myLottos = myLottos;
        this.lottoGenerator = new LottoGenerator();
    }

    public List<MyLotto> buy(int money) {
        int tickets = money / LOTTO_PRICE;

        for (int i = 0; i < tickets; i++) {
            myLottos.add(new MyLotto(lottoGenerator.generate(LottoBasicNumber.numbers)));
        }
        return myLottos;
    }

    public LottoResult checkLuckyCount(LuckyLotto luckyLotto) {
        LottoResult lottoResult = new LottoResult();

        for (MyLotto myLotto : myLottos) {
            lottoResult.addMatchCount(myLotto.matchNumbers(luckyLotto));
            lottoResult.addBonusCount(myLotto.getMatchBonus());
        }
        return lottoResult;
    }
}
