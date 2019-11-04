package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final String WINNING_NUM_DELIMITER = ",";

    public Winner() {

    }
    public Winner(String lastWeekWinningInput) {
        getWinnerTicket(lastWeekWinningInput);
    }

    public int matchNumber(List<Integer> candidateNums, List<Integer> winnerNums) {
        Long matchNumer = candidateNums.stream()
                .filter(winnerNums::contains)
                .count();

        return Math.toIntExact(matchNumer);
    }

    private LottoTicket getWinnerTicket(String lastWeekWinningInput) {
        String[] splitedWinningNums = lastWeekWinningInput.split(WINNING_NUM_DELIMITER);

        int numSize = splitedWinningNums.length;
        List<Integer> winningNums = new ArrayList<>();

        for (int i = 0; i < numSize; i++) {
            winningNums.add(Integer.parseInt(splitedWinningNums[i]));
        }

        return new LottoTicket(winningNums);
    }
}
