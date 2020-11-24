package step3.lotto.domain;

import step3.lotto.domain.numbers.LottoWinningNumber;
import step3.lotto.util.LottoErrorMessage;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private LottoWinningNumber lottoWinningNumber;
    private LottoShop lottoShop = new LottoShop();
    private LottoProfitAmount lottoProfitAmount;
    private Set<SortedSet<Integer>> buyLottoHashSet = new HashSet<>();
    private int lottoPurchaseAmount = 0;
    private int lottoPurchaseCount = 0;
    private int bonusNumber = 0;

    public LottoGame(int purchaseAmount) {
        initMatch(purchaseAmount);
    }

    public void getLottoResult(String winningNumbers, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        LottoMatch.playLottoMatch(winningNumbers, buyLottoHashSet, bonusNumber);
    }

    public void buyLotto() {
        buyLottoHashSet = lottoShop.buyAutoLotto(lottoPurchaseCount);
    }

    public double getlottoProfitAmount() {
        double returnValue = 0.0;
        double totalPrice = LottoProfitAmount.runLottoProfitAmount();

        returnValue = totalPrice / lottoPurchaseAmount;

        return returnValue;
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

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public LottoWinningNumber getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    public LottoShop getLottoShop() {
        return lottoShop;
    }

    public LottoProfitAmount getLottoProfitAmount() {
        return lottoProfitAmount;
    }

    public Set<SortedSet<Integer>> getBuyLottoHashSet() {
        return buyLottoHashSet;
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
