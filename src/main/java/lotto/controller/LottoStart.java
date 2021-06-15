package lotto.controller;

import lotto.domain.LottoesCreator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStart {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoesCreator lottoesCreator = new LottoesCreator();

        outputView.payAmount();
        inputView.countLotto();

        outputView.lastWeekNumbers();

        outputView.lastWeekBonus();

    }
}
