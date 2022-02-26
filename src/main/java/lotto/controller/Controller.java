package lotto.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicketManual;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.RankResult;
import lotto.domain.ShuffleLottoNumber;
import lotto.domain.Winning;
import lotto.domain.dto.LottoCalculationDTO;
import lotto.domain.dto.RankDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private static final InputView inputView;
    private static final OutputView outputView;


    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static void run() {
        Money money = new Money(inputView.inputPurchaseAmount());
        Lottos lottos = new Lottos();
        List<Lotto> calculatedLottos = purchaseLotto(lottos, money);
        calculateLottoRank(calculatedLottos, money);
    }

    private static void calculateLottoRank(List<Lotto> lottos, Money money) {
        String winningLottoNumber = inputView.inputWinningLottoNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(inputView.inputBonusLottoNumber());
        Winning winning = new Winning(winningLottoNumber, bonusLottoNumber);
        RankResult rankResult = new RankResult(lottos, winning);
        Prize prize = new Prize(money);
        RankDTO rankDto = new RankDTO(rankResult, prize);
        outputView.printRankResult(prize, rankDto);
    }

    private static List<Lotto> purchaseLotto(Lottos lottos, Money money) {
        String purchaseManualCount = inputView.inputLottoTicket();
        LottoTicketManual lottoTicket = new LottoTicketManual(purchaseManualCount,
            money.calculateLotto());
        inputView.inputLottoManual();
        List<Lotto> purchaseManualLotto = purchaseManualLotto(lottoTicket);
        int numberOfLottoAutomatical = calculateLottoCount(lottos, money, purchaseManualCount);
        List<Lotto> calculatedLottos = LottoGenerator.lottoBundle(purchaseManualLotto,
            numberOfLottoAutomatical, new ShuffleLottoNumber());
        LottoCalculationDTO lottoCalculationDto = new LottoCalculationDTO(
            purchaseManualLotto.size(), numberOfLottoAutomatical, calculatedLottos);
        outputView.printCountMessage(lottoCalculationDto);
        return calculatedLottos;
    }

    private static List<Lotto> purchaseManualLotto(LottoTicketManual lottoTicket) {
        List<Lotto> purchaseManualLotto = IntStream.range(0, lottoTicket.getLottoTicketValue())
            .mapToObj(inputView::doInputLotto).map(Lotto::new)
            .collect(Collectors.toList());
        return purchaseManualLotto;
    }

    private static int calculateLottoCount(Lottos lottos, Money money,
        String purchaseManualCount) {
        int numberOfLottoManual = Integer.parseInt(purchaseManualCount);
        int numberOfLottoAutomatical = lottos.calculateNumberOfLottosAutomatical(
            numberOfLottoManual,
            money);
        return numberOfLottoAutomatical;
    }


}
