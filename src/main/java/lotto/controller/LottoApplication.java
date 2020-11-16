package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoGenerator;
import lotto.dto.BuyLotto;
import lotto.dto.LottoStatistics;
import lotto.dto.LottosResult;
import lotto.dto.Winning;
import lotto.service.LottoService;
import lotto.view.InputChannel;
import lotto.view.InputView;
import lotto.view.OuputChannel;
import lotto.view.ResultView;

public class LottoApplication {
    private static final InputChannel inputChannel = new InputChannel();
    private static final OuputChannel outputChannel = new OuputChannel();

    private static final LottoService lottoService = new LottoService();
    private static final LottoGenerator lottoGenerator = new RandomLottoGenerator();

    public static void main(String[] args) {
        BuyLotto buyLotto = InputView.inputBuyLotto(inputChannel);

        // 로또 발급
        Lottos lottos = lottoService.issueLottos(buyLotto.getCount(), lottoGenerator);
        LottosResult lottosResult = LottosResult.of(lottos);
        ResultView.outputBuyLotto(outputChannel, lottosResult);

        // 당첨 번호 입력 및 확인
        Winning winning = InputView.inputWinning(inputChannel);
        lottoService.scratchLottos(lottos, winning);

        // 로또 당첨 통계
        LottoStatistics statistics = new LottoStatistics(lottos);
        ResultView.outputStatistics(outputChannel, statistics);
    }
}
