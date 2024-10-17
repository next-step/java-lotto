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

        // 구매 가능 갯수 출력
        int availableLottoTickets = money.availableLottoTickets(lottoTicketPrice);
        outputHandler.showNumberOfTicketsBought(availableLottoTickets);

        // 구매한 로또 각 줄마다 출력
        LottoTickets lottoTickets = LottoTicketGenerator.generateLottoTickets(availableLottoTickets, new RandomLottoNumberGenerator());
        outputHandler.showLottoTickets(lottoTickets);

        // 당첨번호와 보너스번호 입력
        outputHandler.showWinningNumbersText();
        List<String> winningNumbers = inputHandler.getWinningNumbersFromUser();
        outputHandler.showBonusBallText();
        int bonusNumber = inputHandler.getBonusBallFromUser();
        WinningLotto winningLotto = WinningLotto.fromWinningNumbersAndBonusNumber(winningNumbers, bonusNumber);

        // 당첨 통계 출력
        LottoStatistics lottoStatistics = lottoTickets.generateLottoStatistics(winningLotto, lottoTicketPrice);
        outputHandler.showLottoStatistics(lottoStatistics);

    }

}
