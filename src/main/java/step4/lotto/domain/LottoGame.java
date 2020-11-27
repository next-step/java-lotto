package step4.lotto.domain;

import step4.lotto.domain.numbers.LottoTicket;
import step4.lotto.util.LottoErrorMessage;

import java.util.HashSet;
import java.util.Set;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private LottoShop lottoShop = new LottoShop();
    private Set<LottoTicket> buyLottoHashSet = new HashSet<>();
    private int lottoPurchaseAmount = 0;
    private int lottoPurchaseCount = 0;

    public LottoGame(int purchaseAmount) {
        initMatch(purchaseAmount);
    }

    public void getLottoResult(String winningNumbers, int bonusNumber) {
        LottoMatch lottoMatch = new LottoMatch(winningNumbers, buyLottoHashSet, bonusNumber);
        lottoMatch.playLottoMatch();
    }

    public void buyLotto() {
        buyLottoHashSet = lottoShop.buyAutoLotto(lottoPurchaseCount);
    }

    public double getLottoProfitAmount() {
        return LottoProfitAmount.runLottoProfitAmount() / lottoPurchaseAmount;
    }

    private void initMatch(int purchaseAmount) {
        initLottoPurchase(purchaseAmount);
    }

    private void initLottoPurchase(int purchaseAmount) {
        checkPurchase(purchaseAmount);

        this.lottoPurchaseAmount = purchaseAmount;
        this.lottoPurchaseCount = purchaseAmount / LOTTO_PRICE;
    }

    private void checkPurchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new RuntimeException(LottoErrorMessage.getLottoAmountCheck());
        }
    }

    public Set<LottoTicket> getBuyLottoHashSet() {
        return buyLottoHashSet;
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
