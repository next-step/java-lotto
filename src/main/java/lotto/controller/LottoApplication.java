package lotto.controller;

import lotto.domain.*;
import lotto.dto.BuyLotto;
import lotto.dto.MyLottos;
import lotto.dto.PrintLottoResult;
import lotto.service.LottoService;
import lotto.view.InputChannel;
import lotto.view.InputView;
import lotto.view.OuputChannel;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    private static final InputChannel inputChannel = new InputChannel();
    private static final OuputChannel outputChannel = new OuputChannel();

    private static final LottoService lottoService = new LottoService();

    private static final LottoGenerator lottoGenerator = new RandomLottoGenerator();

    public static void main(String[] args) {
        BuyLotto buyLotto = InputView.inputBuyLotto(inputChannel);

        // 로또 발급
        Lottos lottos = lottoService.issueLottos(buyLotto.getCount(), lottoGenerator);
        MyLottos myLottos = MyLottos.of(lottos);
        ResultView.outputBuyLotto(outputChannel, myLottos);

        // 당첨 번호 입력 및 확인
        Winning winning = Winning.of(InputView.inputWinning(inputChannel));
        List<LottoRank> lottoRanks = winning.scratch(lottos);

        // 로또 당첨 통계
        PrintLottoResult statistics = PrintLottoResult.of(new LottoStatistics(lottoRanks));
        ResultView.outputStatistics(outputChannel, statistics);
    }
}
