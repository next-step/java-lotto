package lotto.controller;

import lotto.domain.*;
import lotto.domain.strategy.AutoLottoGeneration;
import lotto.domain.strategy.LottoGeneration;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoController {

    public static final LottoGeneration AUTO_LOTTO_GENERATION = new AutoLottoGeneration(LottoNumberCache.values());

    public void play() {

        Money money = new Money(inputPurchaseAmount());

        Lottos lottos = buyLotto(money);
        checkWinning(lottos, money);

    }

    public Lottos buyLotto(Money money){
        PurchaseQuantity allQuantity =new PurchaseQuantity(money.cutByThousand());
        PurchaseQuantity manualQuantity= new PurchaseQuantity(inputManualCount());

        List<LottoGeneration> manualList = inputManualList(manualQuantity);

        Lottos lottos = new Lottos(allQuantity.diff(manualQuantity),manualList,AUTO_LOTTO_GENERATION);

        printPurchaseCount(allQuantity,manualQuantity);
        printLottoList(lottos);

        return lottos;
    }

    public void checkWinning(Lottos lottos, Money money){
        Lotto winLotto = new Lotto(inputWinLotto().generate());
        LottoNumber bonus = inputBonus();

        LottoRanks lottoRanks = new LottoRanks(lottos,winLotto,bonus);
        printStatistics(lottoRanks.findLottoResult());
        printRateOfReturn(money,lottoRanks.findPrizeMoney());

    }
}
