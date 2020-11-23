package step2.lotto.automatic.domain;

import step2.lotto.automatic.domain.numbers.LottoWinningNumber;
import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.*;

public class LottoMatch {

    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;
    private static final int LOTTO_PRICE = 1000;

    private LottoWinningNumber lottoWinningNumber;
    private LottoShop lottoShop = new LottoShop();
    private LottoProfitAmount LottoProfitAmount;
    private Set<List<Integer>> buyLottoHashSet = new HashSet<>();
    private int lottoPurchaseAmount = 0;
    private int lottoPurchaseCount = 0;

    public LottoMatch(int purchaseAmount) {
        initMatch(purchaseAmount);
    }

    public void getLottoResult(String WinningNumbers) {
        lottoWinningNumber = new LottoWinningNumber(WinningNumbers);

        Iterator it = buyLottoHashSet.iterator();

        while (it.hasNext()) {
            addWinningCount((List<Integer>) it.next());
        }
    }

    public void buyLotto() {
        buyLottoHashSet = lottoShop.buyAutoLotto(lottoPurchaseCount);
    }

    public double getlottoProfitAmount() {
        double returnValue = 0;
        int totalPrice = LottoProfitAmount.runLottoProfitAmount();

        returnValue = totalPrice / lottoPurchaseAmount;
        return returnValue;
    }

    private void addWinningCount(List<Integer> lotto) {
        int rank = lottoWinningNumber.getRank(lotto);
        if (rank >= MATCH_LOTTE_MIN_COUNT && rank <= MATCH_LOTTE_MAX_COUNT) {
            LottoStatusEnum.findByCount(rank).addWinningCount();
        }
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
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2AmountCheck());
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

    public step2.lotto.automatic.domain.LottoProfitAmount getLottoProfitAmount() {
        return LottoProfitAmount;
    }

    public Set<List<Integer>> getBuyLottoHashSet() {
        return buyLottoHashSet;
    }

    public int getLottoPurchaseCount() {
        return lottoPurchaseCount;
    }
}
