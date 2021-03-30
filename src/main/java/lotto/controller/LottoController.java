package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.generator.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final Money amount;
    private final Lottos lottos;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        int amount = InputView.inputAmount();
        this.amount = Money.from(amount);
        this.lottos = Lottos.of(new LottoNumberGenerator(), this.amount);
        this.lottoStatistics = LottoStatistics.from(amount);
    }

    public void run() {
        ResultView.printLottos(lottos);                                                             // 로또 출력
        Lotto prizeLotto = Lotto.from(InputView.inputPrizeLotto(), InputView.inputBonusNumber());   // 당첨 번호 입력
        lottoStatistics.makeStatisticsResult(lottos, prizeLotto);                                   // 당첨 통계용 데이터 생성
        ResultView.printStatistics(lottoStatistics);                                                // 당첨 통계 출력
        ResultView.printRevenueRate(lottoStatistics.getRevenueRate(lottos, prizeLotto));            // 수익률 출력
    }
}
