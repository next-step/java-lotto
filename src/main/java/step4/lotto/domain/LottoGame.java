package step4.lotto.domain;

import step4.lotto.domain.numbers.LottoTicket;
import step4.lotto.util.LottoErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private LottoShop lottoShop = new LottoShop();
    private Set<LottoTicket> buyLottoHashSet = new HashSet<>();
    private int lottoPurchaseAmount = 0;
    private int lottoAutoBuyCount = 0;
    private int lottoManualBuyCount = 0;

    public LottoGame(int purchaseAmount, int lottoManualBuyCount) {
        initLotto(purchaseAmount, lottoManualBuyCount);
    }

    private void initLotto(int purchaseAmount, int lottoManualBuyCount) {
        checkPurchase(purchaseAmount);
        checkLottoManualBuyCount(lottoManualBuyCount, purchaseAmount);

        this.lottoPurchaseAmount = purchaseAmount;
        this.lottoAutoBuyCount = (purchaseAmount / LOTTO_PRICE) - lottoManualBuyCount;
        this.lottoManualBuyCount = lottoManualBuyCount;
    }


    public void getLottoResult(String winningNumbers, int bonusNumber) {
        LottoMatch lottoMatch = new LottoMatch(winningNumbers, buyLottoHashSet, bonusNumber);
        lottoMatch.playLottoMatch();
    }

    public void buyManualLotto(List<String> manualLottoList) {
        if (lottoManualBuyCount > 0) {
            Set<LottoTicket> buyManualLotto = lottoShop.buyManualLotto(manualLottoList, lottoManualBuyCount);
            buyLottoHashSet.addAll(buyManualLotto);
        }
    }

    public void buyAutoLotto() {
        if ((lottoPurchaseAmount / 1000) - lottoManualBuyCount > 0) {
            Set<LottoTicket> buyAutoLotto = lottoShop.buyAutoLotto(lottoAutoBuyCount);
            buyLottoHashSet.addAll(buyAutoLotto);
        }
    }

    public double getLottoProfitAmount() {
        return LottoProfitAmount.runLottoProfitAmount() / lottoPurchaseAmount;
    }


    private void checkPurchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new RuntimeException(LottoErrorMessage.getLottoAmountCheck());
        }
    }

    private void checkLottoManualBuyCount(int lottoManualBuyCount, int purchaseAmount) {
        if ((lottoManualBuyCount * LOTTO_PRICE) > purchaseAmount) {
            throw new RuntimeException(LottoErrorMessage.getLottoManualBuyCountCheck());
        }
    }

    public Set<LottoTicket> getBuyLottoHashSet() {
        return buyLottoHashSet;
    }

    public int getLottoAutoBuyCount() {
        return lottoAutoBuyCount;
    }

    public int getLottoManualBuyCount() {
        return lottoManualBuyCount;
    }
}
