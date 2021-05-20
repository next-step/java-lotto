package lotto.winning;

import lotto.LottoTicket;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class WinningStatistics {
    private static final int MAX_DIGIT = 7;
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int[] WINNING_PRICES = {0,0,0,5000,50000, 1500000, 2000000000};

    private List<Integer> winningPoints;

    public WinningStatistics() {
        initWinningPoints();
    }

    public void initWinningPoints() {
        Integer[] points = new Integer[MAX_DIGIT];
        for (int i = ZERO; i < points.length; i++) {
            points[i] = ZERO;
        }
        this.winningPoints = Arrays.asList(points);
    }

    public List<Integer> getWinningPoints() {
        return this.winningPoints;
    }

    public void calculateTotalWinningPoint(List<LottoTicket> tickets, List<Integer> winningNumbers) {
        for (int i = 0; i < tickets.size(); i++) {
            int winningPointIndex = calculateTicketWinningPoint(tickets.get(i), winningNumbers);
            winningPoints.set(winningPointIndex, winningPoints.get(winningPointIndex)+1);
        }
    }
    public int calculateTicketWinningPoint(LottoTicket lottoTicket, List<Integer> winningNumbers) {
        int winningPoint = ZERO;
        for (int i = ZERO; i < lottoTicket.getLottoTicket().size(); i++) {
            winningPoint += checkContainNumber(winningNumbers, lottoTicket.getLottoTicket().get(i));
        }
        return winningPoint;
    }

    public int checkContainNumber(List<Integer> winningNumbers, int lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            return ONE;
        }
        return ZERO;
    }

    public int changeWinningPointsToMoney(List<Integer> winningPoints) {
        int sum = ZERO;
        for (int i = ZERO; i < winningPoints.size() ; i++) {
            sum += winningPoints.get(i) * WINNING_PRICES[i];
        }
        return sum;
    }

    public double calculateTotalYield(int winningPointMoney, int purchasePrice) {
       return Math.floor(((double) winningPointMoney/purchasePrice) *100)/100.0;
    }

    public void showWinningStatistics(int purchasePrice) {
        ResultView resultView = new ResultView();
        resultView.printStatisticsIntroduction();

        for (int i = 3; i < this.winningPoints.size(); i++) {
            resultView.printStatisticsResult(i, WINNING_PRICES[i], this.winningPoints.get(i));
        }
        int money = changeWinningPointsToMoney(this.winningPoints);
        resultView.printTotalYield(calculateTotalYield(money,purchasePrice));
    }
}
