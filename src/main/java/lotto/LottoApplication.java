package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.prize.LottoAnalyzer;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.LottoUtil;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {

        //로또 금액 입력 및 장수 출력
        int purchaseAmount = InputView.enterPurchaseAmount();
        int quantity = LottoUtil.calculateLottoQuantity(purchaseAmount);
        ResultView.printLottoQuantity(quantity);


        //로또 기계에서 로또 구매
        LottoMachine lottoMachine = LottoMachine.create();
        List<Lotto> lottoTicket = lottoMachine.purchaseLotto(quantity);
        ResultView.printLottoTicket(lottoTicket);

        //당첨번호 입력
        String winningNumber = InputView.enterWinningNumber();
        List<Integer> winningNumbers = LottoUtil.convertWinningNumber(winningNumber);

        //당첨 통계 출력
        LottoAnalyzer lottoAnalyzer = LottoAnalyzer.create();
        Map<Integer, Integer> matchCountMap = lottoAnalyzer.calculateWinningStatistics(lottoTicket, winningNumbers);
        ResultView.printWinStatistics(matchCountMap);

        // 수익율 계산
        double winPrize = lottoAnalyzer.calculateWinPrize(matchCountMap);
        double winRate = lottoAnalyzer.calculateWinRate(purchaseAmount, winPrize);
        ResultView.printWinRate(winRate);

    }
}
