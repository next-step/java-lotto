package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final static int MAX_LOTTO_NUMBER = 45;

    private List<LottoNumber> lotto;
    private int numberOfGame;

    public LottoGame(LottoPrice inputPrice, List<LottoNumber> lottoManual) {
        this.numberOfGame = inputPrice.convertPriceToNumberOfGame() - lottoManual.size();
        lotto = new ArrayList<>();
        lotto = getAutoLottoNumber();

        lottoManual.addAll(lotto);
        lotto = lottoManual;
    }

    public List<LottoNumber> getLotto() {
        return lotto;
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
}
