package lotto;


import lotto.domain.money.Money;
import lotto.domain.number.RandomLottoNumberGenerator;
import lotto.domain.result.LottoStatistics;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

import java.util.List;

public class Lotto {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final Integer lottoTicketPrice;

    public Lotto(InputHandler inputHandler, OutputHandler outputHandler, Integer lottoTicketPrice) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoTicketPrice = lottoTicketPrice;
    }

    public void run() {
        // 구입 금액 입력
        outputHandler.showCommentForPurchaseAmount();
        Money money = Money.of(inputHandler.getPurchaseAmountFromUser());

        // 수동 구매 로또 수 입력
        outputHandler.showCommentForManualLottoPurchaseCount();
        int manualLottoPurchaseCount = inputHandler.getOneNumberFromUser();

        // 수동으로 구매할 번호 입력
        outputHandler.showCommentForManualLottoNumbers();
        List<List<Integer>> manualPurchaseLottoNumbers = inputHandler.getManualPurchaseLottoNumbers(manualLottoPurchaseCount);

        // 수동 및 자동 구매 가능 갯수 출력
        int autoLottoPurchaseCount = money.availableLottoTickets(lottoTicketPrice) - manualLottoPurchaseCount;
        outputHandler.showNumberOfTicketsBought(manualLottoPurchaseCount, autoLottoPurchaseCount);

        // 구매한 로또 각 줄마다 출력
        LottoTickets lottoTickets = LottoTicketGenerator.generateLottoTickets(manualPurchaseLottoNumbers, autoLottoPurchaseCount, new RandomLottoNumberGenerator());
        outputHandler.showLottoTickets(lottoTickets);

        // 당첨번호와 보너스번호 입력
        outputHandler.showWinningNumbersText();
        List<Integer> winningNumbers = inputHandler.getLottoNumbersFromUser();
        outputHandler.showBonusBallText();
        int bonusNumber = inputHandler.getOneNumberFromUser();
        WinningLotto winningLotto = WinningLotto.fromWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // 당첨 통계 출력
        LottoStatistics lottoStatistics = lottoTickets.generateLottoStatistics(winningLotto, lottoTicketPrice);
        outputHandler.showLottoStatistics(lottoStatistics);

    }

}
