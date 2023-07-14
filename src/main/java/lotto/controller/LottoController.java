package lotto.controller;

import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;
import lotto.service.LottoService;
import lotto.view.LottoView;

public final class LottoController {

    public void run() {
        // 1-1. 구입 금액 입력
        LottoView lottoView = new LottoView();
        Payment payment = new Payment(lottoView.readPayment());

        // 1-2. 구입 갯수 & 구입 로또 번호 출력
        LottoService lottoService = new LottoService(payment);
        lottoView.printLottoCount(lottoService.getCount());
        lottoView.printLottos(lottoService.getLottos());

        // 2. 당첨 번호 & 보너스 볼 입력
        String winningLotto = lottoView.readWinningLotto();
        String bonusBall = lottoView.readBonusBall();
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);

        // 3. 당첨 통계 출력
        lottoView.printLottoResult(lottoService.getResult(winningNumber));
        lottoView.printProfitRate(lottoService.getProfitRate());

    }
}
