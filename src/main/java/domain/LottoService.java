package domain;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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


    public LottoTickets purchase(LottoPrice lottoPrice) {
        int manualCount = inputView.inputManualLottoCount();
        int autoCount = lottoPrice.autoCount(manualCount);

        LottoTickets manual = LottoTickets.manual(inputManual(manualCount));
        LottoTickets auto = LottoTickets.auto(autoCount);

        resultView.printLottoCount(manualCount, autoCount);
        return manual.addTickets(auto);
    }

    public List<Lotto> inputManual(int manualCount) {
        return inputView.inputManualLotto(manualCount);
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
                .forEach(lotto -> resultView.printAllLotto(
                        lotto.getLotto().stream().map(LottoNumber::getNumber).collect(Collectors.toList())));
    }

    private List<LottoNumber> receiveAnswer() {
        return inputView.inputAnswerNumber();
    }

    private LottoNumber receiveBonus() {
        return new LottoNumber(inputView.inputBonusNumber());
    }

}
