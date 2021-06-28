package lottogame.service;

public class LottoGame {

    final static int PRICE = 1000;

    public int getBuyCount(int buyPrice) {
        return buyPrice / PRICE;
    }
}
