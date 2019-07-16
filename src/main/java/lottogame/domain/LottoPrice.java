package lottogame.domain;

class LottoPrice {
    private final static int ONE_LOTTO_PRICE = 1000;

    final private int price;

    LottoPrice(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoUtilStrData.WARNING_STR_LOTTO_PRICE_LOWER_THN_MINIMUM.getValue());
        }

        this.price = price;
    }

    int getPrice() {
        return price;
    }

    int convertPriceToNumberOfGame() {
        return price / ONE_LOTTO_PRICE;
    }
}
