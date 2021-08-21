package step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResults {

    private Ticket winningNumbers;
    private Map<Integer, Integer> resultMap = new HashMap<>();

    public void saveWinningLottoNumber(Ticket winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Ticket getWinningLottoNumber() {
        return this.winningNumbers;
    }

    public Map<Integer, Integer> getWinningResult() {
        return resultMap;
    }

    public void checkWinning(LottoTickets lottoTickets) {
        List<Ticket> purchasedTickets = lottoTickets.getLottoTickets();

        for (Ticket purchasedTicket : purchasedTickets) {
                int countCorrectNumber = matchingWinningNumber(purchasedTicket);

                if(countCorrectNumber < 3) {
                    return;
                }

                resultMap.put(countCorrectNumber, resultMap.getOrDefault(countCorrectNumber, 0) + 1);
        }
    }

    private int matchingWinningNumber(Ticket purchasedTicket) {
        return purchasedTicket.getLottoNumbers()
                .stream()
                .filter(n -> checkWinningNumber(n))
                .collect(Collectors.toList())
                .size();
    }

    private boolean checkWinningNumber(int number) {
       return winningNumbers.getLottoNumbers().contains(number);
    }
}
