package me.namuhuchutong.lotto;

import me.namuhuchutong.lotto.controller.LottoController;
import me.namuhuchutong.lotto.domain.generator.RandomNumberGenerator;
import me.namuhuchutong.lotto.ui.InputView;
import me.namuhuchutong.lotto.ui.OutputView;

public class LottoApplication {

    public static void main(String[] args){
        new LottoController(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator()).start();
    }
}
