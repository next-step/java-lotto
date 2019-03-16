package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
import lotto.domain.LottoStatistics;
import lotto.view.LottoView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        doLottery();
    }

    private static void doLottery() {
        try {
            //로또 구매
            int buyCount = LottoView.buyLotto();

            List<Lotto> lottos = new ArrayList<>();

            //로또 번호생성
            for (int i = 0; i < buyCount; i++) {
                Lotto lotto = new Lotto(LottoMarket.createNumbers());
                lottos.add(lotto);
            }

            //생성번호 view
            LottoView.showBuyLottos(lottos);

            //당첨번호 입력
            String[] splitWinningNumbers = LottoView.splitWinningNumbers(LottoView.inputWinningNumbers());
            List<Integer> winningNumbers = LottoMachine.createWinningNumbers(splitWinningNumbers);

            //당첨등수 확인
            for (int number : winningNumbers) {
                LottoMachine.checkWinning(lottos, number);
            }

            //노출 통계자료 생성
            LottoStatistics lottoStatistics = LottoMachine.checkWinningLotto(lottos);

            //통계자료 view
            LottoView.showWinningStatistics(lottoStatistics);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
