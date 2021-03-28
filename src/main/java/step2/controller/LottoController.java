package step2.controller;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.generator.LottoNumberGenerator;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {
    private final Money amount;
    private final Lottos lottos;

    public LottoController() {
        this.amount = Money.from(InputView.inputAmount());              // 구매 금액 입력
        this.lottos = Lottos.of(new LottoNumberGenerator(), amount);
    }

    public void run() {
        ResultView.printPurchaseCount(lottos);                          // 구매 개수 출력
        ResultView.printLottos(lottos);                                 // 구매된 로또 리스트 출력
        Lotto prizeLotto = Lotto.from(InputView.inputPrizeLotto());     // 지난주 당첨번호 입력
        ResultView.printPrizeStats(lottos.getPrizes(prizeLotto));       // 당첨통계 출력
    }
}
