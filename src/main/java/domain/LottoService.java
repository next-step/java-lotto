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
        return new LottoPrice(inputView.inputPurchasePrice());
    }

    public void inputManualLotto(LottoPrice lottoPrice) {
        lottoPrice.manualLottoCount(inputView.inputManualLottoCount());
    }

    public LottoTickets purchaseManualLotto(LottoPrice lottoPrice) {
        inputManualLotto(lottoPrice);
        inputView.inputManualLottoNumber();
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < lottoPrice.getManualLottoCount(); i++) {
            //lottoTickets.addLottoTicket(new Lotto(inputView::inputLotto));
            lottoTickets.addLottoTicket(Lotto.create(inputView.inputLotto()));
        }
        return lottoTickets;
    }


    public LottoTickets purchaseAutoLotto(LottoTickets lottoTickets, LottoPrice lottoPrice) {
        lottoTickets.readyLottoTicket(lottoPrice.getAutoLottoCount());
        resultView.printLottoCount(lottoPrice.getManualLottoCount(), lottoPrice.getAutoLottoCount());
        showAllLottoTickets(lottoTickets);
        return lottoTickets;
    }

    public void getRatioByAnswer(LottoTickets lottoTickets, LottoPrice lottoPrice) {
        LottoAnswer answer = new LottoAnswer(receiveAnswer(), receiveBonus());
        LottoResult result = answer.checkLottoAnswer(lottoTickets.getLottos());
        resultView.printResultStatistic(result);

        BigDecimal prizeRatio = new RatioCalculator().calculateRatio(lottoPrice.getPurchasePrice(), result);
        resultView.printResultRatio(prizeRatio);
    }

    private void showAllLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottos()
                .forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));
    }

    private List<Integer> receiveAnswer() {
        return inputView.inputAnswerNumber();
    }

    private int receiveBonus() {
        return inputView.inputBonusNumber();
    }

}
