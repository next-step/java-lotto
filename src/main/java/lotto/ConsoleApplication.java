package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
import lotto.dto.Lotto;
import lotto.dto.LottoProfit;
import lotto.dto.LottoStatistics;
import lotto.dto.LottoWinningNumber;
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
            LottoProfit lottoProfit = LottoInputView.buyLotto();

            //로또 생성
            List<Lotto> lottos = LottoMarket.createLottos(lottoProfit.getBuyCount());

            //생성번호 view
            LottoOutputView.showBuyLottos(lottos);

            //당첨번호 입력
            String[] splitWinningNumbers = LottoInputView.splitWinningNumbers(LottoInputView.inputWinningNumbers());

            //보너스 번호 입력
            int bonusNumber = LottoInputView.inputBounusNumber();

            //입력값 예외 확인 및 당첨번호 리스트 생성
            LottoWinningNumber lottoWinningNumber = LottoInputView.createWinningNumbers(splitWinningNumbers, bonusNumber);

            //당첨등수 확인
            LottoStatistics lottoStatistics = LottoMachine.getLottoStatistics(lottos, lottoWinningNumber, lottoProfit);

            //통계자료 view
            LottoOutputView.showWinningStatistics(lottoStatistics);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
