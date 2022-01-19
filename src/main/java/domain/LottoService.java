package domain;

import view.InputView;
import view.ResultView;

import java.util.Map;

public class LottoService {
    private LottoTickets lottoTickets;
    private final InputView inputView;
    private final ResultView resultView;
    private static final int lottoPrice = 1_000;
    private int purchasePrice;

    public LottoService() {
        this.lottoTickets = new LottoTickets();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void purchaseLotto() {
        purchasePrice = inputView.inputPurchasePrice();
        int lottoCount = purchasePrice / lottoPrice;
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.addLottoTicket(new Lotto());
        }
        resultView.printLottoCount(lottoCount);
    }

    public void showAllLottoTickets() {
        lottoTickets.getLottoTickets()
                .forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));
    }

    public void receiveAnswerNumber() {
        Map<Integer, Integer> matchCount = new AnswerLotto(inputView.inputAnswerNumber())
                .checkLottoAnswer(lottoTickets.getLottoTickets());
        resultView.printResultStatistic(matchCount);
    }

    public void finishLotto() {
        lottoTickets.calculateLottoTotalPrize();
        resultView.printResultRatio(lottoTickets.calculateLottoRatio(purchasePrice));
    }
}
