package step2.model;

public class LottoCount {
    private final int lottoCount;

    private static final int MIN_LOTTO_COUNT = 0;
    private static final int LOTTO_PRICE = 1000;

    public LottoCount(String lottoCount) {
        isBlank(lottoCount);
        isDigit(lottoCount);
        this.lottoCount = Integer.parseInt(lottoCount);
    }

    public LottoCount(PurchaseAmount purchaseAmount, String lottoCount) {
        isBlank(lottoCount);
        isDigit(lottoCount);
        isValidCount(purchaseAmount, Integer.parseInt(lottoCount));
        this.lottoCount = calcLottoCount(purchaseAmount);
    }

    private void isBlank(String amount) {
        if (amount == null || amount.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isDigit(String amount) {
        if (!amount.matches("[0-9]*")) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void isValidCount(PurchaseAmount purchaseAmount, int lottoCount) {
        int maxLottoCount = calcLottoCount(purchaseAmount);
        if ( lottoCount < MIN_LOTTO_COUNT || lottoCount > maxLottoCount) {
            throw new IllegalArgumentException("구매할 로또수를 다시 확인해주세요. 최소 " + MIN_LOTTO_COUNT
                    + " ~ 최대 " + maxLottoCount + "개 까지 구매 가능합니다.");
        }
    }

    private int calcLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getLottoCount();
    }

    public int getPurchaseAmount() {
       return lottoCount * LOTTO_PRICE;
    }
}

