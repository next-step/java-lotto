package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final static int MAX_LOTTO_NUMBER = 45;

    private List<LottoNumber> lotto;
    private LottoPrice price;
    private int numberOfGame;

    public LottoGame(int inputPrice, List<LottoNumber> lottoManual) {
        price = new LottoPrice(inputPrice);
        this.numberOfGame = price.convertPriceToNumberOfGame() - lottoManual.size();
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

    private ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> randomNumber = new ArrayList<>();
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumber.add(i);
        }
        Collections.shuffle(randomNumber);
        return randomNumber;
    }

    private void mergeList(List<LottoNumber> lottoManual){
        List<LottoNumber> lottoTotal = new ArrayList<>();
        lottoTotal.addAll(lottoManual);
        lottoTotal.addAll(lotto);
        lotto = lottoTotal;
    }
}
