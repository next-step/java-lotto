package lotto.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCalculation;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicketManual;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.Winning;
import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private static final InputView inputView;

    static{
        inputView = new InputView();
    }

    public static void run() {
        Money money = new Money(inputView.inputPurchaseAmount());
        LottoCalculation lottoCalculation = new LottoCalculation(money);
        purchaseLottoManual(lottoCalculation, money);
        purchaseLottoAutomatical(lottoCalculation, money);
    }

    private static void purchaseLottoAutomatical(LottoCalculation lottoCalculation, Money money) {
        String winningLottoNumber = inputView.inputWinningLottoNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(inputView.inputBonusLottoNumber());
        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        RankResult rankResult = new RankResult(lottoCalculation.getLottos(), winning);
        RankDTO rankDto = rankResult.getRankResult(winning, money);
        OutputView.printRankResult(rankDto);
    }

    private static void purchaseLottoManual(LottoCalculation lottoCalculation, Money money) {

        LottoTicketManual lottoTicket = new LottoTicketManual(lottoCalculation, inputView.inputLottoTicket());
        inputView.inputLottoManual();
        List<Lotto> purchaseManualLotto = IntStream.range(0, lottoTicket.getLottoTicketValue())
            .mapToObj(inputView::doInputLotto)
            .map(Lotto::new)
            .collect(Collectors.toList());
        LottoCalculationDTO lottoCalculationDTO = lottoCalculation.getPurchaseLottos(purchaseManualLotto,money);
        OutputView.printCountMessage(lottoCalculationDTO);
    }
}
