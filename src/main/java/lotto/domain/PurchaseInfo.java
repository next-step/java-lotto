package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class PurchaseInfo {

    public static final int LOTTO_PRICE = 1000;

    private final int purchaseAmount;
    private final int autoLottoCount;
    private final List<Lotto> manualLottos;

    public PurchaseInfo(int autoLottoPurchaseAmount) {
        this(LOTTO_PRICE, autoLottoPurchaseAmount, new ArrayList<>());
    }

    public PurchaseInfo(int autoLottoPurchaseAmount, List<String> manualLottoNumber) {
        this(LOTTO_PRICE, autoLottoPurchaseAmount, toLotto(manualLottoNumber));
    }

    public PurchaseInfo(int price, int purchaseAmount, List<Lotto> manualLottos) {
        this.purchaseAmount = purchaseAmount;
        this.autoLottoCount = calculateCount(price, purchaseAmount);
        this.manualLottos = manualLottos;
    }

    private static List<Lotto> toLotto(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(s -> Lotto.ofString(s.split(",")))
                .collect(Collectors.toList());
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

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }
}
