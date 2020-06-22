package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLottoResult;
import lotto.utils.LottoShuffle;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_GAME_PRICE;

public class LottoController {

    private Money money;
    private int buyCount;
    private List<Lotto> lottos;

    public LottoController(Money money) {

        lottos = new ArrayList<Lotto>();
        this.money = money;
        buyCount = money.getBuyCount();
    }

    public void createLotto() {

        for (int i = 0; i < buyCount; i++) {
            List<LottoNumber> lottoNumbers = LottoShuffle.makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            Output.printBuyLottoNumber(lotto);
            lottos.add(lotto);
        }

    }


    public WinningLottoResult matchLotto(Lotto winningLotto) {
        WinningLottoResult lottoResult = new WinningLottoResult();
        for (Lotto lotto : lottos) {
            int count = lotto.matchCount(winningLotto);
            lottoResult.match(count);
        }
        return lottoResult;
    }
}
