package step2.controller;

import step2.domain.*;
import step2.dto.LottoDto;
import step2.view.InputView;
import step2.view.RenderView;

import java.util.List;

public class LottoController {
    public static void run() {
        LottoDto lottoDto = InputView.inputPurchaseMoney();

        Money myMoney = Money.of(lottoDto.getPurchaseMoney());

        List<Lotto> lottoList = LottoIssuer.issueLottos(myMoney);
        PurChasedLotto purChasedLotto = new PurChasedLotto(lottoList);

        RenderView.showLottoList(lottoList);

        LottoDto lottoDto2 = InputView.inputWinningLottoNumber();

        WinningLotto winningLotto = WinningLotto.create(lottoDto2.getWinningLottoNumber(), lottoDto2.getBonusNumber());

        purChasedLotto.matchNumber(winningLotto);

        RenderView.showWinningStatic(purChasedLotto.getRankInfo());
        RenderView.showTotalYield(myMoney.totalYield(purChasedLotto.getTotalPrize()));
    }
}
