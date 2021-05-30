package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import io.mwkwon.lotto.interfaces.DataGenerator;
import io.mwkwon.lotto.interfaces.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoStore {

    private final DataGenerator dataGenerator;
    private final LottoGenerator lottoGenerator;

    public LottoStore(DataGenerator dataGenerator, LottoGenerator lottoGenerator) {
        this.dataGenerator = dataGenerator;
        this.lottoGenerator = lottoGenerator;
    }

    public BuyLottos buyAutoLottos(LottoPayment lottoPayment, PurchaseQuantity manualLottoPurchaseQuantity) {
        PurchaseQuantity autoLottoPurchaseQuantity = manualLottoPurchaseQuantity.calcAutoLottoPurchaseQuantity(lottoPayment);
        return lottoGenerator.createAutoLottos(autoLottoPurchaseQuantity);
    }

    public Lotto createWinningLotto() {
        return dataGenerator.requestWinningLottoNumbers();
    }

    public LottoPayment createLottoPayment() {
        return dataGenerator.requestInputPayment();
    }

    public LottoNumber createBonusBallLottoNumber(Lotto winningLotto) {
        return dataGenerator.requestBonusBallNumber(winningLotto);
    }

    public WinningRanks calcLottosRank(BuyLottos buyLottos, WinningLotto winningLotto) {
        List<Rank> ranks = buyLottos.calcLottoRank(winningLotto);
        List<Rank> winningRanks = ranks.stream().filter(rank -> rank != Rank.MISS).collect(Collectors.toList());
        return new WinningRanks(winningRanks);
    }

    public PurchaseQuantity createManualLottoPurchaseQuantity(LottoPayment lottoPayment) {
        return dataGenerator.requestManualLottoPurchaseQuantity(lottoPayment);
    }

    public BuyLottos createManualLottos(PurchaseQuantity purchaseQuantity) {
        List<LottoNumbers> manualLottoNumbers = dataGenerator.requestManualLottoNumbers(purchaseQuantity);
        List<Lotto> lottos = manualLottoNumbers
                .stream()
                .map(lottoNumbers -> lottoGenerator.createManualLotto(lottoNumbers))
                .collect(Collectors.toList());

        return BuyLottos.create(lottos);
    }
}
