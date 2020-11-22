package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatch {

    private static final int MATCH_LOTTE_MAX_COUNT = 4;
    private static final int MATCH_LOTTE_MIN_COUNT = 1;
    private static final int LOTTO_PRICE = 1000;

    private static LottoWinningNumber lottoWinningNumber;
    private static LottoShop lottoShop = new LottoShop();
    private static LottoProfitAmount LottoProfitAmount;
    private static Map<Integer, LottoStatusEnum> lottoResult = new HashMap<>();
    private static List<List<Integer>> buyLottoList = new ArrayList<>();
    private static int LottoPurchaseAmount = 0;
    private static int LottoPurchaseCount = 0;

    private static

    LottoStatusEnum lottoStatusEnum;

    public LottoMatch(int purchaseAmount) {
        initMatch(purchaseAmount);

    }

    public Map<Integer, LottoStatusEnum> getLottoResult(String WinningNumbers) {
        lottoWinningNumber = new LottoWinningNumber(WinningNumbers);

        for (List<Integer> lotto : buyLottoList) {
            addWinningCount(lotto);
        }

        return lottoResult;
    }

    public double getLottoProfitAmount(Map<Integer, LottoStatusEnum> paramValue){
        double returnValue = 0;
        int totalPrice = LottoProfitAmount.runLottoProfitAmount(paramValue);

        returnValue = totalPrice / LottoPurchaseAmount;
        return returnValue;
    }

    private void addWinningCount(List<Integer> lotto) {
        if (lottoResult.containsKey(lottoWinningNumber.getRank(lotto))) {
            lottoResult.get(lottoWinningNumber.getRank(lotto)).addWinningCount();
        }
    }

    private void initMatch(int purchaseAmount) {
        initLottoRank();
        initLottoPurchase(purchaseAmount);
    }

    private void initLottoPurchase(int purchaseAmount) {
        checkPurchase(purchaseAmount);

        this.LottoPurchaseAmount = purchaseAmount;
        this.LottoPurchaseCount = purchaseAmount / LOTTO_PRICE;
    }

    private void checkPurchase(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2AmountCheck());
        }
    }

    /**
     * 순위당 상태 초기화
     * 1 - 1등
     * 2 - 2등
     * 3 - 3등
     * 4 - 4등
     */
    private void initLottoRank() {
        for (int i = MATCH_LOTTE_MIN_COUNT; i <= MATCH_LOTTE_MAX_COUNT; i++) {
            lottoStatusEnum = LottoStatusEnum.findByPrice(i);
            lottoResult.put(i, lottoStatusEnum);
        }
    }

    public void buyLottoNumber() {
        buyLottoList = lottoShop.buyLotto(LottoPurchaseCount);
    }

    public static List<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

    public static int getLottoPurchaseAmount() {
        return LottoPurchaseAmount;
    }

    public static int getLottoPurchaseCount() {
        return LottoPurchaseCount;
    }
}
