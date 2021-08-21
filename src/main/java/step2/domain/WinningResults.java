package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResults {

    private static final int TICKET_PRICE = 1000;
    private Ticket winningNumbers;
    private Map<Award, Integer> resultMap = new HashMap<>();
    private double rateOfReturn;

    public void saveWinningLottoNumber(String winningNumbers) {
        this.winningNumbers = initWinningNumber(winningNumbers);
    }

    private static Ticket initWinningNumber(String winningNumbers) {
        Ticket winningNumberLastWeek = new Ticket();
        List<Integer> ticket = new ArrayList<>();

        String[] winningNumbersArray = winningNumbers.split(",");

        for (String winningNumber : winningNumbersArray) {
            ticket.add(Integer.parseInt(winningNumber.trim()));
        }

        winningNumberLastWeek.saveLottoNumbers(ticket);
        return winningNumberLastWeek;
    }

    public Ticket getWinningLottoNumber() {
        return this.winningNumbers;
    }

    public Map<Award, Integer> getWinningResult() {
        return resultMap;
    }

    public void checkWinning(LottoTickets lottoTickets) {
        List<Ticket> purchasedTickets = lottoTickets.getLottoTickets();
        int totalWinningAmount = 0;

        for (Ticket purchasedTicket : purchasedTickets) {
            Award awardResult = matchingWinningNumber(purchasedTicket);
            totalWinningAmount += awardResult.getWinningMoney();
            resultMap.put(awardResult, resultMap.getOrDefault(awardResult, 0) + 1);
        }

        calculateRateOfReturn(totalWinningAmount, purchasedTickets.size() * TICKET_PRICE);
    }

    private Award matchingWinningNumber(Ticket purchasedTicket) {
        return Award.valueOf(purchasedTicket.getLottoNumbers()
                .stream()
                .filter(n -> checkWinningNumber(n))
                .count());
    }

    private boolean checkWinningNumber(int number) {
        return winningNumbers.getLottoNumbers().contains(number);
    }


    private void calculateRateOfReturn(int totalWinningAmount, int purchaseAmount) {
        this.rateOfReturn = (double) totalWinningAmount / (double) purchaseAmount;
    }

    public double getRateOfReturn() {
        return Math.floor(rateOfReturn * 100) / 100;
    }

}
