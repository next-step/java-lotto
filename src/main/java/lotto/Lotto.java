package lotto;


import lotto.config.GameConfig;
import lotto.domain.ticket.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.number.RandomLottoNumberGenerator;
import lotto.domain.result.LottoStatistics;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;

public class Lotto {

    private final Integer lottoTicketPrice;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Lotto(GameConfig gameConfig) {
        this.lottoTicketPrice = gameConfig.getLottoTicketPrice();
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
    }

    public void run() {
        // 구입 금액 입력
        outputHandler.showCommentForPurchaseAmount();
        Money money = Money.of(inputHandler.getPurchaseAmountFromUser());

        // 구매 가능 갯수 출력
        int availableLottoTickets = money.availableLottoTickets(lottoTicketPrice);
        outputHandler.showNumberOfTicketsBought(availableLottoTickets);

        // 구매한 로또 각 줄마다 출력
        LottoTickets lottoTickets = LottoTicketGenerator.generateTickets(availableLottoTickets, new RandomLottoNumberGenerator());
        outputHandler.showLottoTickets(lottoTickets);

        // 당첨번호 입력
        outputHandler.showWinningNumbersText();
        WinningLotto winningLotto = inputHandler.getWinningNumbersFromUser();

        // 당첨 통계 출력
        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winningLotto, lottoTicketPrice);
        outputHandler.showLottoStatistics(lottoStatistics);

    }

}
