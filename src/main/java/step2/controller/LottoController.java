package step2.controller;

import step2.Dto.LottoDto;
import step2.domain.Lotto;
import step2.domain.LottoIssuer;
import step2.domain.PurChasedLotto;
import step2.view.InputView;
import step2.view.RenderView;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    public static void run() {
        LottoDto dto1 = InputView.inputPurchaseMoney();

        List<Lotto> lottoList = LottoIssuer.issue(dto1.getPurchaseMoney());
        PurChasedLotto purChasedLotto = new PurChasedLotto(lottoList);

        RenderView.showLottoList(lottoList);

        LottoDto dto2 = InputView.inputWinningLottoNumber();

        Lotto WinningLotto = Lotto.create(dto2.getWinningLottoNumber());

        purChasedLotto.matchNumber(WinningLotto);

        RenderView.showWinningStatic(purChasedLotto.getRankInfo());
        RenderView.showTotalYield(purChasedLotto.totalYield(dto1.getPurchaseMoney()));
    }
}
