package lotto.controller;


import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.Winning;
import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public static void run() {
        Money money = new Money(InputView.inputPurchaseAmount());
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        purchaseLottoManual(lottoCalculation, money);
        purchaseLottoAutomatical(lottoCalculation, money);
    }

    private static void purchaseLottoAutomatical(LottoCalculation lottoCalculation, Money money) {
        String winningLottoNumber = InputView.inputWinningLottoNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(InputView.inputBonusLottoNumber());
        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        RankResult rankResult = new RankResult(lottoCalculation.getPurchaseLottos(), winning);
        RankDTO rankDto = rankResult.getRankResult(winning, money);
        OutputView.printRankResult(rankDto);
    }

    private static void purchaseLottoManual(LottoCalculation lottoCalculation, Money money) {
        LottoTicket lottoTicket = new LottoTicket(money, InputView.inputLottoTicket());
        List<Lotto> purchaseManualLotto = InputView.inputPurchaseManualLotto(lottoTicket.getLottoTicketValue());
        Lottos lottos = new Lottos(purchaseManualLotto);
        LottoCalculationDTO lottoCalculationDTO = lottoCalculation.purchaseLottos(lottos);
        OutputView.printCountMessage(lottoCalculationDTO);
    }
}
