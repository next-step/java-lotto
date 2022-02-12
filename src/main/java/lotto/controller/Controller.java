package lotto.controller;


import lotto.domain.LottoCalculation;
import lotto.domain.LottoTicket;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public static void run() {
        LottoCalculation lottoCalculation = new LottoCalculation(InputView.inputPurchaseAmount());
        purchaseLottoManual(lottoCalculation);
        purchaseLottoAutomatical(lottoCalculation);
    }

    private static void purchaseLottoAutomatical(LottoCalculation lottoCalculation) {
        Winning winning = lottoCalculation.makeWinningLottoNumber(
            InputView.inputWinningLottoNumber(), InputView.inputBonusLottoNumber());
        RankDTO rankDto = lottoCalculation.getRankResult(winning);
        OutputView.printRankResult(rankDto);
    }

    private static void purchaseLottoManual(LottoCalculation lottoCalculation) {
        LottoTicket lottoTicket = lottoCalculation.makeLottoTicket(InputView.inputLottoTicket());
        Lottos lottos = InputView.inputPurchaseManualLotto(lottoTicket.getLottoTicketValue());
        LottoCalculationDTO lottoCalculationDTO = lottoCalculation.purchaseLottos(lottos);
        OutputView.printCountMessage(lottoCalculationDTO);
    }
}
