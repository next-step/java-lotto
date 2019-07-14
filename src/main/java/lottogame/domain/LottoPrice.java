package lottogame.domain;

class LottoPrice {
    private final static int ONE_LOTTO_PRICE = 1000;

    final private int price;

    LottoPrice(int price) {
        if (price < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 다시 프로그램을 실행 후 올바른 가격을 입력해주세요.");
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
