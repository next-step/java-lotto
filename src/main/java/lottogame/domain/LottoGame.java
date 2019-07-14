package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int SUBLIST_POINT_FIRST = 0;
    private final static int SUBLIST_POINT_LAST = 6;

    private List<LottoNumber> lotto;
    final private LottoPrice price;
    final private int numberOfGame;

    public LottoGame(int inputPrice, List<LottoNumber> lottoManual) {
        price = new LottoPrice(inputPrice);
        numberOfGame = price.convertPriceToNumberOfGame() - lottoManual.size();
        if(numberOfGame <0){
            throw new IllegalArgumentException("수동로또 구매 수량이 구매가격을 초과하였습니다.");
        }

        lotto = new ArrayList<>();
        lotto = getAutoLottoNumber();

        mergeList(lottoManual);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    LottoPrice getPrice() {
        return price;
    }

    private List<LottoNumber> getAutoLottoNumber() {
        for (int i = 0; i < numberOfGame; i++) {
            lotto.add(new LottoNumber(getRandomNumber()));
            Collections.sort(lotto.get(i).getElement());
        }
        return lotto;
    }

    private List<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);
        return randomNumber.subList(SUBLIST_POINT_FIRST,SUBLIST_POINT_LAST);
    }

    private void mergeList(List<LottoNumber> lottoManual){
        List<LottoNumber> lottoTotal = new ArrayList<>();
        lottoTotal.addAll(lottoManual);
        lottoTotal.addAll(lotto);
        lotto = lottoTotal;
    }
}
