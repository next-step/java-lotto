package domain;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    private final InputView inputView;
    private final ResultView resultView;
    private final static int lottoPrice = 1000;
    private int purchasePrice;
    private int lottoCount;
    private int totalPrize;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void lottoProcess() {
        purchasePrice = inputView.inputPurchasePrice();
        lottoCount = purchasePrice / lottoPrice;
        resultView.printLottoCount(lottoCount);
        purchaseLotto().forEach(lotto -> resultView.printAllLotto(lotto.getLotto()));

        resultView.printResultStatistic(
                checkLottoAnswer(inputView.inputAnswerNumber()));

        calculateLottoTotalPrize();
        resultView.printResultRatio(calculateLottoRatio());
    }

    public List<Lotto> purchaseLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
        //lottoTickets.stream().limit(lottoCount).forEach(lotto -> lottoTickets.add(new Lotto()));
    }


    public int[] checkLottoAnswer(List<Integer> answerNumbers) {
        final int[] lottoResult = new int[7];
        for (Lotto lotto : lottoTickets) {
            lottoResult[lotto.checkLottoNumbers(answerNumbers)]++;
        }
        return lottoResult;
    }


    public void calculateLottoTotalPrize() {
        for (Lotto lotto : lottoTickets) {
            totalPrize += lotto.getPrizeMoney();
        }
    }

    public String calculateLottoRatio() {
        return String.format("%.2f", (double) totalPrize / (double) purchasePrice);
    }

}
