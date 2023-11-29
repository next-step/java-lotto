package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.LottoService;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView outputView = new OutputView();

        int totalMoney = Integer.parseInt(input.money());
        LottoService lottoService = new LottoService(
            totalMoney, new RandomGenerator()
        );
        outputView.printLotto(lottoService.getLottoNumberList());

        List<Integer> winningNumbers = Arrays.stream(input.winningNumbers().split(", "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        int bonusNumber = Integer.parseInt(input.bonusNumber());
        lottoService.drawLotto(winningNumbers, bonusNumber);

        outputView.printStatistics(lottoService.totalWinningStatistics(),
            lottoService.returnRate());
    }
}
