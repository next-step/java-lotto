package lotto.controller.lotto;

import lotto.domain.Amount;
import lotto.domain.lotto.LottoList;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.domain.money.Money;
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

    public LottoList purchaseLotto(final Money money) {
        Amount totalAmount = lottoPurchaseService.purchaseNumber(money);
        LottoList lottoList = purchaseAutoLotto(totalAmount, purchaseManualLotto());
        LottoOutput.lotto(lottoList.toStringList());
        return lottoList;
    }

    private LottoList purchaseAutoLotto(final Amount amount, final LottoList lottoList) {
        Amount manualLottoAmount = new Amount(lottoList.size());
        Amount autoLottoAmount = amount.minus(manualLottoAmount.amount());
        LottoOutput.purchaseCount(manualLottoAmount.amount(), autoLottoAmount.amount());
        return lottoList.addAll(lottoPurchaseService.purchaseLotto(autoLottoAmount));
    }

    private LottoList purchaseManualLotto() {
        LottoOutput.purchaseManualAmount();
        Amount manualAmount = inputManualAmount();
        LottoOutput.manualLottoNumbers();

        return lottoPurchaseService.purchaseLotto(
                IntStream.range(0, manualAmount.amount())
                        .mapToObj(i -> LottoInput.lottoNumbers(LottoNumberSet.LOTTONUMBERSET_DELIMITER))
                        .map(ints -> new LottoNumberSet(ints))
                        .collect(Collectors.toList())
        );
    }

    private static Amount inputManualAmount() {
        try {
            return new Amount(LottoInput.purchaseManualAmount());
        } catch (Exception e) {
            LottoOutput.purchaseManualAmountInputException();
        }
        return inputManualAmount();
    }
}
