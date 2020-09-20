package step2.controller;

import step2.domain.*;
import step2.dto.LottoDto;
import step2.view.InputView;
import step2.view.RenderView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {
    public static void run() {
        LottoDto lottoDto = InputView.inputPurchaseMoney();

        Money myMoney = Money.of(lottoDto.getPurchaseMoney());

        LottoDto lottoDto2 = InputView.inputCustomLottoNumberList();

        List<Lotto> nonAutoLottoList = LottoIssuer.issueNonAutoLotto(lottoDto2.getNonAutoLottoNumberList());
        List<Lotto> autoLottoList = LottoIssuer.issueAutoLottos(myMoney.getNumberOfPurchases() - nonAutoLottoList.size());
        List<Lotto> totalLottoList = Stream.concat(nonAutoLottoList.stream(), autoLottoList.stream())
                                            .collect(Collectors.toList());

        PurChasedLotto purChasedLotto = new PurChasedLotto(totalLottoList);

        RenderView.showLottoList(nonAutoLottoList, autoLottoList);

        LottoDto lottoDto3 = InputView.inputWinningLottoNumber();

        WinningLotto winningLotto = WinningLotto.create(lottoDto3.getWinningLottoNumber(), lottoDto3.getBonusNumber());

        purChasedLotto.matchNumber(winningLotto);

        RenderView.showWinningStatic(purChasedLotto.getRankInfo());
        RenderView.showTotalYield(myMoney.totalYield(purChasedLotto.getTotalPrize()));
    }
}
