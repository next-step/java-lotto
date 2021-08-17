package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberStragey;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    List<LottoNumber> lotto;
    LottoNumber winningNumber;

    public GameController() {
        lotto = new ArrayList<>();
        winningNumber = new LottoNumber();
    }

    public void init() {

        InputView inputView = new InputView();

        for(int count = 0; count < inputView.buyLottoView(); count++) {
            lotto.add(new LottoNumber());
            lotto.get(count).setAutoNumber(new LottoNumberStragey());
        }

    }

}
