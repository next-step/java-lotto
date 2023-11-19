package lotto.controller;

import lotto.domain.lotto.wrapper.LottoNumbers;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseController {

    private final InputView inputView;
    private final ResultView resultView;

    public PurchaseController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public List<LottoNumbers> purchase() {
        int numOfLotto = inputView.inputPurchaseMoney();
        int countOfManual = inputView.inputCountOfManual(numOfLotto);

        List<LottoNumbers> lottos = drawLottos(countOfManual, numOfLotto - countOfManual);

        showPurchaseResult(countOfManual, lottos);
        return lottos;
    }

    private List<LottoNumbers> drawLottos(int countOfManual, int countOfAuto) {
        List<LottoNumbers> lottos = new ArrayList<>();

        lottos.addAll(drawManual(countOfManual));
        lottos.addAll(drawAuto(countOfAuto));

        return lottos;
    }

    private List<LottoNumbers> drawManual(int countOfManual) {
        return IntStream.range(0, countOfManual)
            .mapToObj(i -> new LottoNumbers(inputView.inputManualLotto(i)))
            .collect(Collectors.toList());
    }

    private List<LottoNumbers> drawAuto(int numOfLotto) {
        return IntStream.range(0, numOfLotto)
            .mapToObj(i -> LottoMachine.drawLottoNumbers())
            .collect(Collectors.toUnmodifiableList());
    }

    private void showPurchaseResult(int countOfManual, List<LottoNumbers> lottos) {
        resultView.printNumOfLotto(countOfManual, lottos.size() - countOfManual);
        resultView.printLottoNumbers(lottos);
    }
}
