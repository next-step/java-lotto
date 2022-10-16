package lotto.controller.lotto;

import lotto.domain.Amount;
import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.service.LottoPurchaseService;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseController {

    private final LottoPurchaseService lottoPurchaseService;

    public LottoPurchaseController(LottoPurchaseService lottoPurchaseService) {
        this.lottoPurchaseService = lottoPurchaseService;
    }

    public List<Lotto> purchaseLotto(final ImmutableMoney immutableMoney) {
        Amount totalAmount = lottoPurchaseService.purchaseNumber(immutableMoney);
        List<Lotto> lottoList = purchaseAutoLotto(totalAmount, purchaseManualLotto());
        LottoOutput.lotto(lottoList);
        return lottoList;
    }

    private List<Lotto> purchaseAutoLotto(final Amount totalAmount, final List<Lotto> lottoList) {
        Amount autoAmount = totalAmount.minus(new Amount(lottoList.size()));
        LottoOutput.purchaseCount(new Amount(lottoList.size()), autoAmount);
        lottoList.addAll(lottoPurchaseService.purchaseLotto(autoAmount));
        return lottoList;
    }

    private List<Lotto> purchaseManualLotto() {
        LottoOutput.purchaseManualAmount();
        Amount manualAmount = LottoInput.purchaseManualAmount();
        LottoOutput.manualLottoNumbers();
        return lottoPurchaseService.purchaseLotto(inputLottoNumberSet(manualAmount));
    }

    private static List<LottoNumberSet> inputLottoNumberSet(final Amount manualAmount) {
        List<LottoNumberSet> lottoNumberSets = new ArrayList<>();
        for (int i = 0; i < manualAmount.amount(); i++) {
            lottoNumberSets.add(LottoInput.lottoNumbers());
        }
        return lottoNumberSets;
    }
}
