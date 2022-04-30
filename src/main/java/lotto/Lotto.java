package lotto;

import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;
    private static final String BUY_PRICE_VALID_ERROR_MESSAGE = "1,000원 단위로만 구매 가능합니다.";
    private static final String MAX_QUANTITY_ERROR_MESSAGE = "생성할 수 있는 수량을 초과하였습니다.";

    private final LottoNumbers lottoNumbers;

    private final int buyPrice;

    public Lotto(String buyPrice) {
        this(buyPrice, new LottoNumbers());
    }

    public Lotto(String buyPrice, LottoNumbers lottoNumbers) {
        this(Integer.parseInt(buyPrice), lottoNumbers);
    }

    public Lotto(int buyPrice, LottoNumbers lottoNumbers) {
        this.buyPrice = buyPrice;
        this.lottoNumbers = lottoNumbers;
        validate();
    }

    private void validate() {
        if (buyPrice % PRICE != 0) {
            throw new IllegalArgumentException(BUY_PRICE_VALID_ERROR_MESSAGE);
        }
        if (!isRemainedQty()) {
            throw new IllegalArgumentException(MAX_QUANTITY_ERROR_MESSAGE);
        }
    }

    public void auto() {
        validate();
        int remainedQty = getRemainedQty();
        for (int i = 0; i < remainedQty; i++) {
            this.lottoNumbers.add(LottoGenerator.generate());
        }
    }

    private boolean isRemainedQty() {
        return getRemainedQty() >= 0;
    }

    private int getRemainedQty() {
        return getBuyQuantity() - lottoNumbers.getQuantity();
    }

    public int getBuyQuantity() {
        return buyPrice / PRICE;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
