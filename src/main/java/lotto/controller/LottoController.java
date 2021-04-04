package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.WinningLotto;
import lotto.generator.LottoNumberGenerator;
import lotto.factory.LottoFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final Money amount;
    private final LottoStatistics lottoStatistics;

    public LottoController() {
        int amount = InputView.inputAmount();
        this.amount = Money.from(amount);
        this.lottoStatistics = LottoStatistics.from(amount);
    }

    public void run() {
        List<Lotto> manualLottos = LottoFactory.buyManualLottos(InputView.inputManualLottoNumbers(), amount);   // 수동 번호 구매
        List<Lotto> autoLottos = LottoFactory.buyAutoLottos(new LottoNumberGenerator(), amount);                // 자동 번호 구매
        Lottos lottos = Lottos.of(manualLottos, autoLottos);

        ResultView.printLottos(manualLottos.size(), autoLottos.size(), lottos);                     // 로또 출력

        Lotto prizeLotto = Lotto.from(InputView.inputPrizeLotto());                                 // 지난주 당첨 번호 입력
        Number bonusNumber = Number.from(InputView.inputBonusNumber());                             // 보너스 번호 입력
        WinningLotto winningLotto = WinningLotto.of(prizeLotto, bonusNumber);                       // 당첨번호 + 보너스번호 객체 생성

        lottoStatistics.makeStatisticsResult(lottos, winningLotto);                                 // 당첨 통계용 데이터 생성
        ResultView.printStatistics(lottoStatistics);                                                // 당첨 통계 출력
    }
}
