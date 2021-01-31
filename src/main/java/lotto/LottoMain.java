package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.*;
import lotto.util.ROICalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {

        LottoController lottoController = new LottoController();
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
