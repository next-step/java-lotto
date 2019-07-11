package lottogame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
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
            lotto.add(new LottoNumber());
            Collections.sort(lotto.get(i).getElement());
        }
        return lotto;
    }
}
