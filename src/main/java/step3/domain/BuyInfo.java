package step3.domain;

import java.util.List;

public class BuyInfo {
    private static final int ZERO = 0;
    private static final int ONE_GAME_PRICE = 1000;
    private int totalPrice;
    private int totalCount;
    private int autoCount = 0;
    private int manualCount = 0;
    private BuyLotto buyLotto;

    public BuyLotto getBuyLotto() {
        return buyLotto;
    }

    public BuyInfo(int totalPrice) {
        validateBuyInfo(totalPrice);
        this.totalPrice = totalPrice;
        this.totalCount = totalPrice / ONE_GAME_PRICE;
    }

    private void validateBuyInfo(int totalPrice) {
        if (totalPrice <= ZERO) {
            throw new IllegalArgumentException("로또 구매가격은 0보다 커야합니다.");
        }
        if (totalPrice < ONE_GAME_PRICE) {
            throw new IllegalArgumentException("구매가격은 로또 장당가격인 " + ONE_GAME_PRICE + "보다 큰 금액 입력");
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public BuyInfo(int totalPrice, String[] manualLottoNumbers) {
        validateBuyInfo(totalPrice);

        if (totalPrice / ONE_GAME_PRICE < manualLottoNumbers.length) {
            throw new IllegalArgumentException("구입금액내에서 수동로또를 구매할 수 있습니다.");
        }

        this.totalPrice = totalPrice;
        this.manualCount = manualLottoNumbers.length;
        this.totalCount = totalPrice / ONE_GAME_PRICE;
        this.autoCount = totalCount - this.manualCount;
        this.buyLotto = new BuyLotto(autoCount, manualLottoNumbers);
    }

    public List<LottoNumberList> printList() {
        return this.getBuyLotto().getBuyLottoList();
    }
}
