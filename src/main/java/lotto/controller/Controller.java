package lotto.controller;


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

        LottoTicket lottoTicket = new LottoTicket(InputView.inputLottoTicket(),
            money.lottoCalculation());

        Lottos lottos = InputView.inputPurchaseManualLotto(lottoTicket.getLottoTicketValue());

        LottoCalculation lottoCalculation = new LottoCalculation();

        LottoCalculationDTO lottoCalculationDTO = lottoCalculation.purchaseLottos(money, lottos);
        OutputView.printCountMessage(lottoCalculationDTO);

        Lotto winningLottoNumber = new Lotto(InputView.inputWinningLottoNumber());
        LottoNumber bonusLottoNumber = InputView.inputBonusLottoNumber();

        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);

        RankResult rankResult = new RankResult(lottoCalculationDTO.getLottos(), winning);

        RankDTO rankDTO = lottoCalculation.getCalculationLottoResult(rankResult, money);
        showLottoResult(money, rankDTO);
    }

    private static void showLottoResult(Money money, RankDTO rankDto) {
        OutputView.printRankResult(money, rankDto);
    }
}
