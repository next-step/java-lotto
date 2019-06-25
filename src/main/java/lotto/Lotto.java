package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    static final String LAST_WEEK_WINNUM_DELIMITER = ",";
    private List<Integer> lottoGameNumbers;
    private int winnerNumberCount = 0;
    private int bonusNumberCount = 0;

    public Lotto(List<Integer> lottoGameNumbers) {
        this.lottoGameNumbers = lottoGameNumbers;
        lottoNumberValidationCheck();
    }

    public int getWinnerNumberCount() {
        return winnerNumberCount;
    }

    public int getBonusNumberCount() {
        return bonusNumberCount;
    }

    public void winnerCheck(String lastWeekWinnerNumber, String lastWeekBonusNumber) {
        String[] lastWeekwinNumbers = lastWeekWinnerNumber.split(LAST_WEEK_WINNUM_DELIMITER);
        for (String winNumber : lastWeekwinNumbers) {
            winnerNumberCount += isWinnerNumber(winNumber);
            bonusNumberCount += isWinnerNumber(lastWeekBonusNumber);
        }
    }

    public String lottoNumber() {
        return lottoGameNumbers.stream()
                .map(num -> Integer.toString(num))
                .collect(Collectors.joining(","));
    }

    private int isWinnerNumber(String winNumber) {
        if (lottoGameNumbers.contains(Integer.parseInt(winNumber))) {
            return NumberEnum.LOTTO_IS_WINNER_NUMBER_COUNT.value();
        }
        return NumberEnum.LOTTO_ISNOT_WINNER_NUMBER_COUNT.value();
    }

    private void lottoNumberValidationCheck() {
        if (islottoNumberWrongSize() || islottoNumberDuplicate()) {
            throw new IllegalStateException("로또 번호의 수가 6이 아니거나 중복된 숫자가 있습니다.");
        }
    }

    private boolean islottoNumberWrongSize() {
        return lottoGameNumbers.size() != NumberEnum.LOTTO_DEFAULT_SIZE.value();
    }

    private boolean islottoNumberDuplicate() {
        return lottoGameNumbers.stream()
                .distinct()
                .count() != lottoGameNumbers.size();
    }

}
