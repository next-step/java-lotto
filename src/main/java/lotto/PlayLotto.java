package lotto;

public class PlayLotto {
    private static final int LOTTO_PRICE = 1000;

    public int buyLotto(int money){
        return money / LOTTO_PRICE;
    }

}
