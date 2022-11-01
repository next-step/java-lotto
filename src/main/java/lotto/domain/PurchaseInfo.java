package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class PurchaseInfo {

    public static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final int autoLottoCount;
    private final List<String> manualLottos;

    public PurchaseInfo(int autoLottoPurchaseAmount) {
        this(LOTTO_PRICE, autoLottoPurchaseAmount, new ArrayList<>());
    }

    public PurchaseInfo(int autoLottoPurchaseAmount, List<String> manualLottoNumber) {
        this(LOTTO_PRICE, autoLottoPurchaseAmount, manualLottoNumber);
    }

    public PurchaseInfo(int price, int autoLottoPurchaseAmount, List<String> manualLottos) {
        this.purchaseAmount = autoLottoPurchaseAmount;
        this.autoLottoCount = calculateCount(price, autoLottoPurchaseAmount);
        this.manualLottos = manualLottos;
    }
    
    private int calculateCount(int price, int pay) {
        if (pay % price != 0) {
            throw new IllegalArgumentException("잘못된 구매 금액 입니다");
        }
        return pay / price;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }
}
