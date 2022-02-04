package domain;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoService() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public LottoPrice inputPrice() {
        LottoPrice lottoPrice = new LottoPrice(inputView.inputPurchasePrice());
        resultView.printLottoCount(lottoPrice.lottoCount());
        return lottoPrice;
    }

    public LottoTickets purchaseLotto(LottoPrice lottoPrice) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.readyLottoTicket(lottoPrice.lottoCount());
        showAllLottoTickets(lottoTickets);
        return lottoTickets;
    }

    public void getRatioByAnswer(LottoTickets lottoTickets, LottoPrice lottoPrice) {
        AnswerLotto answerLotto = new AnswerLotto(receiveAnswer(), receiveBonus());
        Map<Rank, Integer> matchCount = answerLotto.checkLottoAnswer(lottoTickets.getLottoTickets());
        resultView.printResultStatistic(matchCount);

        BigDecimal prizeRatio = RatioCalculator.calculateRatio(lottoPrice.lottoCount(), matchCount);
        resultView.printResultRatio(prizeRatio);
    }

    private void showAllLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets()
                .forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));
    }

    private List<Integer> receiveAnswer() {
        return inputView.inputAnswerNumber();
    }

    private int receiveBonus() {
        return inputView.inputBonusNumber();
    }

}
