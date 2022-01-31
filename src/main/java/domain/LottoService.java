package domain;

import view.InputView;
import view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int lottoPrice = 1_000;
    private final LottoTickets lottoTickets;
    private final InputView inputView;
    private final ResultView resultView;
    private int purchasePrice;
    private BigDecimal totalPrize;

    public LottoService() {
        this.lottoTickets = new LottoTickets();
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.totalPrize = BigDecimal.ZERO;
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
        List<Integer> answerNumber = inputView.inputAnswerNumber();
        int bonusNumber = inputView.inputBonusNumber();

        Map<Rank, Integer> matchCount = new AnswerLotto(answerNumber, bonusNumber)
                .checkLottoAnswer(lottoTickets.getLottoTickets());
        resultView.printResultStatistic(matchCount);

        calculateLottoTotalPrize(matchCount);
        resultView.printResultRatio(calculateLottoRatio());
    }

    private void calculateLottoTotalPrize(Map<Rank, Integer> matchCount) {
        for (Rank rank : Rank.values()) {
            int prize = rank.getPrize();
            int count = matchCount.getOrDefault(rank, 0);
            totalPrize = totalPrize.add(new BigDecimal(prize * count));
        }
    }

    private BigDecimal calculateLottoRatio() {
        return totalPrize.divide(new BigDecimal(purchasePrice), 2, BigDecimal.ROUND_HALF_UP);
    }
}
