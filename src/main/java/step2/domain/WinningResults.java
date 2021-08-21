package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResults {

    private Ticket winningNumbers;
    private Map<Award, Integer> resultMap = new HashMap<>();

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

        for (Ticket purchasedTicket : purchasedTickets) {
            Award awardResult = matchingWinningNumber(purchasedTicket);
            resultMap.put(awardResult, resultMap.getOrDefault(awardResult, 0) + 1);
        }
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
}
