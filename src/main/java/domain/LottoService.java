package domain;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;
import java.util.List;

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
        LottoAnswer lottoAnswer = new LottoAnswer(receiveAnswer(), receiveBonus());
        LottoResult lottoResult = lottoAnswer.checkLottoAnswer(lottoTickets.getLottoTickets());
        resultView.printResultStatistic(lottoResult);

        BigDecimal prizeRatio = new RatioCalculator().calculateRatio(lottoPrice.getPurchasePrice(), lottoResult);
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
