package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_IS_WINNER_NUMBER_COUNT = 1;
    private static final int LOTTO_ISNOT_WINNER_NUMBER_COUNT = 0;
    private static final int LOTTO_DEFAULT_SIZE = 6;
    static final String LAST_WEEK_WINNUM_DELIMITER = ",";
    private List<Integer> lottoGameNumbers;
    private int winnerNumberCount = 0;

    public Lotto(List<Integer> lottoGameNumbers) {
        this.lottoGameNumbers = lottoGameNumbers;
        lottoNumberValidationCheck();
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

    public String lottoNumber() {
        return lottoGameNumbers.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(","));
    }

    private int isWinnerNumber(String winNumber) {
        if (lottoGameNumbers.contains(Integer.parseInt(winNumber))) {
            return LOTTO_IS_WINNER_NUMBER_COUNT;
        }
        return LOTTO_ISNOT_WINNER_NUMBER_COUNT;
    }

    private void lottoNumberValidationCheck() {
        if (islottoNumberWrongSize() || islottoNumberDuplicate()) {
            throw new IllegalStateException("로또 번호의 수가 6이 아니거나 중복된 숫자가 있습니다.");
        }
    }

    private boolean islottoNumberWrongSize() {
        return lottoGameNumbers.size() != LOTTO_DEFAULT_SIZE;
    }

    private boolean islottoNumberDuplicate() {
        return lottoGameNumbers.stream()
                .distinct()
                .count() != lottoGameNumbers.size();
    }

}
