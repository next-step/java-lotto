package domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoGame {
    private final static int SUBSTR_RANGE = 3;

    private ArrayList<LottoNumber> lotto;
    private LottoResult gameResult;
    private int numberOfGame;
    private int price;

    public LottoGame(int inputPrice) {
        this.price = inputPrice;
        this.numberOfGame = convertPriceToNumberOfGame(inputPrice);
        lotto = new ArrayList<LottoNumber>();
        gameResult = new LottoResult();
    }

    public ArrayList<LottoNumber> getAutoLottoNumber() {
        for (int i = 0; i < numberOfGame; i++) {
            lotto.add(new LottoNumber());
            Collections.sort(lotto.get(i).getElement());
        }
        return lotto;
    }

    private int convertPriceToNumberOfGame(int price) {
        String priceString = String.valueOf(price);
        return Integer.parseInt(priceString.substring(0, priceString.length() - SUBSTR_RANGE));
    }

    public LottoResult getWinningResult(int[] winningNumber, int bonusBall) {
        gameResult.getCountsWinningResult(lotto, winningNumber, bonusBall, price);
        return this.gameResult;
    }
}
