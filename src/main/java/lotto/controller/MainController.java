package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.LottoService;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView outputView = new OutputView();

        LottoService lottoService = new LottoService(
            Integer.parseInt(input.money()), new RandomGenerator()
        );
        outputView.printLotto(lottoService.getLottoNumberList());

        lottoService.drawLotto(
            Arrays.stream(input.winningNumbers().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
            , Integer.parseInt(input.bonusNumber()));

        outputView.printStatistics(lottoService.totalWinningStatistics(),
            lottoService.returnRate());
    }
}
