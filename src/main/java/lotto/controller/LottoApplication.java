package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.domain.factory.LottosFactory;
import lotto.dto.BuyLotto;
import lotto.dto.MyLottos;
import lotto.dto.PrintLottoResult;
import lotto.view.*;

import java.util.List;

public class LottoApplication {
    private static final Input inputChannel = new InputChannel();
    private static final Output outputChannel = new OuputChannel();

    public static void main(String[] args) {
        BuyLotto buyLotto = InputView.inputBuyLotto(inputChannel);

        // 로또 발급
        Lottos lottos = LottosFactory.create(buyLotto.getManualCount(), buyLotto.getRandomCount());
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
