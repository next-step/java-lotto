package lotto.controller;

import lotto.domain.LottoNumberCache;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PurchaseQuantity;
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

        PurchaseQuantity allQuantity =new PurchaseQuantity(money.cutByThousand());
        PurchaseQuantity manualQuantity= new PurchaseQuantity(inputManualCount());

        List<LottoGeneration> manualList = inputManualList(manualQuantity);

        Lottos lottos = new Lottos(allQuantity.diff(manualQuantity),manualList,AUTO_LOTTO_GENERATION);

        printPurchaseCount(allQuantity,manualQuantity);
        printLottoList(lottos);

    }
}
