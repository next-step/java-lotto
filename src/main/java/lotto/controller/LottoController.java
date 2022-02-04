package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.util.Statistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

//    private void

    public void start() {
        OutputView.printRequestLottoPrice();
        int lottoPrice = InputView.readPrice();

        Lottos lottos = new Lottos(lottoPrice);
        List<Lotto> lottoLists = lottos.getLottoLists();

        OutputView.printLottoCount(lottos.getLottoCount());

        for (int i = 0; i < lottoLists.size(); i++) {
            for (int j = 0; j < lottoLists.get(i).getLottoList().size(); j++) {
                System.out.print(lottoLists.get(i).getLottoList().get(j) + " ");
            }
            System.out.println();
        }
        OutputView.printWinningNumberBefore();

        String winningNumber = InputView.readWinningNumber();
        List<Integer> winningNumberList = stringToIntegerList(winningNumber);
        OutputView.printBonusBallNumber();
        int bonusBall = InputView.readBonusNumber();

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumberList, bonusBall,
            lottoLists);
        List<Statistics> lottoResults = lottoStatistics.getResultStatistics();

        for (int i = 0; i < lottoResults.size(); i++) {
            if(lottoResults.get(i).getGrade()>=3) {
                System.out.println(
                    lottoResults.get(i).getGrade() + "개 일치(" + lottoResults.get(i).getMoney() + "원)");
            }
        }
    }

    private List<Integer> stringToIntegerList(String winningNumber) {
        return Arrays.asList(winningNumber.split(", ")).stream().map(Integer::parseInt).collect(
            Collectors.toList());
    }
}
