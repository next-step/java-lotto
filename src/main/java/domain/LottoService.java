package domain;

import view.InputView;
import view.ResultView;

import java.util.Map;

public class LottoService {
    private LottoTickets lottoTickets;
    private LottoNumber lottoNumber;
    private final InputView inputView;
    private final ResultView resultView;
    private final static int lottoPrice = 1000;
    private int purchasePrice;

    public LottoService() {
        this.lottoNumber = new LottoNumberAuto();
        this.lottoTickets = new LottoTickets();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void purchaseLotto() {
        purchasePrice = inputView.inputPurchasePrice();
        int lottoCount = purchasePrice / lottoPrice;
        lottoTickets.addLottoTicket(lottoCount, new Lotto(lottoNumber)); //test 일때 로또티켓리스트에 원하는 티켓들 넣을 수 있게
        resultView.printLottoCount(lottoCount);
    }

    public void showAllLottoTickets() {
        lottoTickets.getLottoTickets()
                .forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));
    }

    public void receiveAnswerNumber() {
        Map<Integer, Integer> matchCount = lottoTickets.checkLottoAnswer(inputView.inputAnswerNumber());
        resultView.printResultStatistic(matchCount);
    }

    public void finishLotto() {
        lottoTickets.calculateLottoTotalPrize();
        resultView.printResultRatio(lottoTickets.calculateLottoRatio(purchasePrice));
    }
}
