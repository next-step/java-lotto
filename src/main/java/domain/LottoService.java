package domain;

import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoTickets lottoTickets;
    private final InputView inputView;
    private final ResultView resultView;
    private static final int lottoPrice = 1_000;
    private final int purchasePrice;

    public LottoService() {
        this.lottoTickets = new LottoTickets();
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.purchasePrice = inputView.inputPurchasePrice();
    }

    public void purchaseLotto() {
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

    public void getRatioByAnswer() {
        AnswerLotto answerLotto = new AnswerLotto(receiveAnswer(), receiveBonus());
        Map<Rank, Integer> matchCount = answerLotto.checkLottoAnswer(lottoTickets.getLottoTickets());
        resultView.printResultStatistic(matchCount);

        resultView.printResultRatio(new PrizeRatio().calculateLottoRatio(purchasePrice, matchCount));
    }

    private List<Integer> receiveAnswer() {
        return inputView.inputAnswerNumber();
    }

    private int receiveBonus() {
        return inputView.inputBonusNumber();
    }

}
