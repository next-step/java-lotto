package lotto.domain;

import java.util.*;

public class WinnerNumbers {
    private final List<Integer> winnerNummbers = new ArrayList<>();
    private HashMap<Integer, Integer> prizeStatus = new HashMap<>();

    public WinnerNumbers(List<Integer> generatedNumbers) {
        winnerNummbers.addAll(generatedNumbers);
        prizeStatus.put(3, 0);
        prizeStatus.put(4, 0);
        prizeStatus.put(5, 0);
        prizeStatus.put(6, 0);
    }

    @Override
    public String toString() {
        return this.winnerNummbers.toString();
    }

    public int calculateTotalMatchedCount(LottoTicket lottoTicket) {
        int sum = 0;
        for (int i = 0; i < lottoTicket.ticket().size(); i++) {
            if (winnerNummbers.contains(lottoTicket.ticket().get(i))) {
                sum++;
            }
        }
        return sum;
    }
}
