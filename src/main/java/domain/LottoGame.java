package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGame {
    private final static int SUBSTR_RANGE = 3;

    private ArrayList<LottoNumber> lotto;
    private int numberOfGame;
    private int price;

    public LottoGame(int inputPrice) {
        this.price = inputPrice;
        this.numberOfGame = convertPriceToNumberOfGame(inputPrice);
        lotto = new ArrayList<LottoNumber>();
    }

    public ArrayList<LottoNumber> getAutoLottoNumber() {
        for (int i = 0; i < numberOfGame; i++) {
            lotto.add(new LottoNumber());
            Collections.sort(lotto.get(i).getElement());
        }
        return lotto;
    }

    public int convertPriceToNumberOfGame(int price) {
        String priceString = String.valueOf(price);
        return Integer.parseInt(priceString.substring(0, priceString.length() - SUBSTR_RANGE));
    }

    public void showWinningResult(int[] winningNumber, int bonusBall) {
        LottoResult.getCountsWinningResult(lotto, winningNumber, bonusBall, price);
    }
}
