package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final static int SUBSTR_RANGE = 3;
    private final static int MINIMUM_PRICE = 1000;

    private List<LottoNumber> lotto;
    private int numberOfGame;

    public LottoGame(int inputPrice, int numberofLottoManual) {
        if (checkPrice(inputPrice)) {
            throw new IllegalArgumentException("최소 금액 1000원 보다 작은 금액이 입력되었습니다. 가격을 다시 한번 입력해주세요.");
        }
        this.numberOfGame = convertPriceToNumberOfGame(inputPrice) - numberofLottoManual;
        lotto = new ArrayList<>();
    }

    public List<LottoNumber> getAutoLottoNumber() {
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

    private boolean checkPrice(int price) {
        return price < MINIMUM_PRICE;
    }
}
