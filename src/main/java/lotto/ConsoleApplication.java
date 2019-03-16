package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
import lotto.domain.LottoStatistics;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        doLottery();
    }

    private static void doLottery() {
        try {
            //로또 구매
            int buyCount = LottoInputView.buyLotto();

            //로또 생성
            List<Lotto> lottos = LottoMarket.createLottos(buyCount);

            //생성번호 view
            LottoOutputView.showBuyLottos(lottos);

            //당첨번호 입력
            String[] splitWinningNumbers = LottoInputView.splitWinningNumbers(LottoInputView.inputWinningNumbers());

            //입력값 예외 확인 및 당첨번호 리스트 생성
            List<Integer> winningNumbers = LottoInputView.createWinningNumbers(splitWinningNumbers);

            //당첨등수 확인
            LottoStatistics lottoStatistics = LottoMachine.getLottoStatistics(lottos, winningNumbers);

            //통계자료 view
            LottoOutputView.showWinningStatistics(lottoStatistics);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
