package lotto;

import lotto.model.*;

import static lotto.model.LottoNumber.winningToSet;
import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        Price price = new Price(buyPrice());
        int manualQuantity = manual();

        LottoFactory lottoFactory = new LottoFactory(manualQuantity, price);
        int autoQuantity = lottoFactory.rest(price);

        Lottos buyLotto = new Lottos(lottoFactory.addLotto(autoQuantity, manualNumber(manualQuantity)));
        printQuantity(lottoFactory, autoQuantity);
        printBuyLottos(buyLotto);

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningToSet(winningLotto())), LottoNumber.cacheLottoNumber(bonusLotto()));
        RankGroup rankGroup = buyLotto.collectRanks(winningLotto);

        Profit profit = new Profit(price.totalQuantity());
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
