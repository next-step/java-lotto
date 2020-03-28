package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoResultView;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LottoRun {

    public static void main(String[] args) {
        LottoResultView lottoResultView = new LottoResultView();
        Scanner scanner = new Scanner(System.in);

        lottoResultView.viewMoneyGuidance();
        Integer inputMoney = scanner.nextInt();

        Money myMoney = new Money(inputMoney);
        LottoMachine lottoMachine = new LottoMachine(myMoney);

        List<Lotto> myLottos = lottoMachine.getLottos();
        lottoResultView.viewLottoCount(myLottos);
        lottoResultView.viewLottos(myLottos);

        lottoResultView.viewWinningNumberGuidance();
        String inputWinningNumbers = scanner.next();
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers);
        lottoResultView.viewLottoNumbers(winningLotto.getWinningLotto());

        LottoInspector lottoInspector = new LottoInspector(winningLotto, myLottos);
        Map<Integer, Integer> result = lottoInspector.getMatchedResult();
        lottoResultView.viewInspect(result);

        int totalRevenue = lottoInspector.getTotalRevenue();
        lottoResultView.viewInsight(myMoney, totalRevenue);
    }
}
