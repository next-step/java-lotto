package lotto.controller.lotto;

import lotto.domain.Amount;
import lotto.domain.lotto.LottoList;
import lotto.domain.money.ImmutableMoney;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.service.LottoPurchaseService;
import lotto.view.lotto.LottoInput;
import lotto.view.lotto.LottoOutput;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchaseController {

    private final LottoPurchaseService lottoPurchaseService;

    public LottoPurchaseController(LottoPurchaseService lottoPurchaseService) {
        this.lottoPurchaseService = lottoPurchaseService;
    }

    public LottoList purchaseLotto(final ImmutableMoney immutableMoney) {
        Amount totalAmount = lottoPurchaseService.purchaseNumber(immutableMoney);
        LottoList lottoList = purchaseAutoLotto(totalAmount, purchaseManualLotto());
        LottoOutput.lotto(lottoList.toStringList());
        return lottoList;
    }

    private LottoList purchaseAutoLotto(final Amount amount, final LottoList lottoList) {
        Amount manualLottoAmount = new Amount(lottoList.size());
        amount.minus(manualLottoAmount);
        LottoOutput.purchaseCount(manualLottoAmount.amount(), amount.amount());
        return lottoList.addAll(lottoPurchaseService.purchaseLotto(amount));
    }

    private LottoList purchaseManualLotto() {
        LottoOutput.purchaseManualAmount();
        Amount manualAmount = new Amount(LottoInput.purchaseManualAmount());
        LottoOutput.manualLottoNumbers();

        return lottoPurchaseService.purchaseLotto(
                IntStream.range(0, manualAmount.amount())
                .mapToObj(i -> LottoInput.lottoNumbers(LottoNumberSet.LOTTONUMBERSET_DELIMITER))
                .map(ints -> new LottoNumberSet(ints))
                .collect(Collectors.toList())
        );
    }
}
