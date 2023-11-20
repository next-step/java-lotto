package lotto;

import lotto.domain.*;
import lotto.domain.strategy.AutoNumberGeneration;
import lotto.domain.strategy.NumberGeneration;

import java.util.List;

import static lotto.ui.InputView.*;
import static lotto.ui.ResultView.*;

public class LottoController {

    public static final NumberGeneration AUTO_NUMBER_GENERATION = new AutoNumberGeneration(LottoNumberCache.values());

    public static void main(String[] args) {

        Money amount = new Money(inputPurchaseAmount());
        PurchaseQuantity allQuantity = new PurchaseQuantity(amount.calculateUnits());
        PurchaseQuantity manualQuantity = new PurchaseQuantity(inputManualCount());

        Lottos lottos = Lottos.generate(inputManualList(manualQuantity), AUTO_NUMBER_GENERATION, allQuantity.diff(manualQuantity));

        printLottoCount(allQuantity, manualQuantity);
        printLottoBundle(lottos.find());

        Lotto winNumbers = new Lotto(inputWiningNumbers());
        LottoNumber bonus = LottoNumber.valueOf(inputBonusBall());

        LottoRanks lottoRanks = new LottoRanks(lottos, winNumbers, bonus);

        printMatchStats(lottoRanks.find());
        printMatchResult(lottoRanks.findPrizeMoney(), amount);

    }
}
