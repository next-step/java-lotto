package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_IS_WINNER_NUMBER_COUNT = 1;
    private static final int LOTTO_ISNOT_WINNER_NUMBER_COUNT = 0;
    static final String LAST_WEEK_WINNUM_DELIMITER = ",";
    private List<Integer> lottoGameNumbers;
    private int winnerNumberCount = 0;

    public Lotto(List<Integer> lottoGameNumbers) {
        this.lottoGameNumbers = lottoGameNumbers;
    }

    public int getWinnerNumberCount() {
        return winnerNumberCount;
    }

    public void winnerCheck(String lastWeekWinnerNumber) {
        String[] lastWeekwinNumbers = lastWeekWinnerNumber.split(LAST_WEEK_WINNUM_DELIMITER);
        for (String winNumber : lastWeekwinNumbers) {
            winnerNumberCount += isWinnerNumber(winNumber);
        }
    }

    private int isWinnerNumber(String winNumber) {
        if (lottoGameNumbers.contains(Integer.parseInt(winNumber))) {
            return LOTTO_IS_WINNER_NUMBER_COUNT;
        }
        return LOTTO_ISNOT_WINNER_NUMBER_COUNT;
    }

    public String lottoNumber() {
        return lottoGameNumbers.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(","));
    }

}
