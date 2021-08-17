package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    List<LottoNumber> lotto;
    InputView inputView;

    public GameController() {
        lotto = new ArrayList<>();
        inputView = new InputView();
    }

    public void init() {

    }

}
