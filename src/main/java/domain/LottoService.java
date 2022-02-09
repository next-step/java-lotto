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

    public LottoTickets purchaseLotto(LottoPrice lottoPrice) {
        LottoTickets lottoTickets = new LottoTickets();
        int manualCount = purchaseManualLotto(lottoTickets);
        int autoCount = lottoPrice.lottoCount() - manualCount;
        purchaseAutoLotto(lottoTickets, autoCount);
        resultView.printLottoCount(manualCount, autoCount);
        return lottoTickets;
    }

    public int purchaseManualLotto(LottoTickets lottoTickets) {
        int count = inputView.inputManualLottoCount();
        inputView.inputManualLottoNumber();
        for (int i = 0; i < count; i++) {
            lottoTickets.addLottoTicket(Lotto.create(inputView.inputLotto()));
        }
        return count;
    }

    public void purchaseAutoLotto(LottoTickets lottoTickets, int count) {
        lottoTickets.readyLottoTicket(count);
    }

    public void getRatioByAnswer(LottoTickets lottoTickets, LottoPrice lottoPrice) {
        LottoAnswer answer = new LottoAnswer(receiveAnswer(), receiveBonus());
        LottoResult result = answer.checkLottoAnswer(lottoTickets.getLottos());
        resultView.printResultStatistic(result);

        BigDecimal prizeRatio = new RatioCalculator().calculateRatio(lottoPrice.getPurchasePrice(), result);
        resultView.printResultRatio(prizeRatio);
    }

    public void showAllLottoTickets(LottoTickets lottoTickets) {
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
