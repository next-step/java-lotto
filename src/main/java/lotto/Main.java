package lotto;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {
    public static void main(String[] args) {
        Price price = new Price(buyPrice());
        ManualQuantity manualQuantity = new ManualQuantity(manualQuantity(), price);
        printRequestToInput();

        List<LottoFactory> lottoFactories = new ArrayList<>();

        for (int i = 0; i < manualQuantity.getManualQuantity(); i++) {
            lottoFactories.add(new LottoFactory(manualNumber()));
        }

        LottosFactory lottosFactory = new LottosFactory(lottoFactories);
        int autoQuantity = manualQuantity.restQuantity(price);

        Lottos buyLotto = lottosFactory.allLottos(autoQuantity);
        printQuantity(manualQuantity, autoQuantity);
        printBuyLottos(buyLotto);

        WinningLotto winningLotto = new WinningLotto(new LottoFactory(winningLotto()).stringToLotto(), LottoNumber.lottoNumber(bonusLotto()));
        RankGroup rankGroup = buyLotto.collectRanks(winningLotto);

        Profit profit = new Profit(price.totalQuantity());
        printResult(rankGroup, profit.calculate(rankGroup));
    }
}
