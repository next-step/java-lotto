package domain;

import view.InputView;
import view.ResultView;

public class LottoService {
    private LottoTickets lottoTickets;
    private final InputView inputView;
    private final ResultView resultView;
    private final static int lottoPrice = 1000;
    private int purchasePrice;

    public LottoService() {
        this.lottoTickets = new LottoTickets();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void purchaseLotto() {
        purchasePrice = inputView.inputPurchasePrice();
        int lottoCount = purchasePrice / lottoPrice;
        lottoTickets.addLottoTicket(lottoCount);
        resultView.printLottoCount(lottoCount);
    }

    public void showAllLottoTickets() {
        lottoTickets.getLottoTickets()
                .forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));
    }

    public void receiveAnswerNumber() {
        int[] answerNumber = lottoTickets.checkLottoAnswer(inputView.inputAnswerNumber());
        resultView.printResultStatistic(answerNumber);
    }

    public void finishLotto() {
        lottoTickets.calculateLottoTotalPrize();
        resultView.printResultRatio(lottoTickets.calculateLottoRatio(purchasePrice));
    }
}
