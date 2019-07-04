package lotto.model;

import lotto.enumset.InitEnum;
import lotto.enumset.LottoEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoOneLine {

    static final String LAST_WEEK_WINNUM_DELIMITER = ",";
    private List<LottoNumber> lottoGameNumbers;

    public LottoOneLine(List<LottoNumber> lottoGameNumbers) {
        this.lottoGameNumbers = lottoGameNumbers;
        lottoNumberValidationCheck();
    }

    public int winnerCheck(String lastWeekWinnerNumber) {
        List<String> lastWeekwinNumbers = Arrays.asList(
                lastWeekWinnerNumber.split(LAST_WEEK_WINNUM_DELIMITER)
        );
        return (int) lastWeekwinNumbers.stream()
                                       .filter(num -> isWinnerNumber(num))
                                       .count();
    }

    public String lottoNumber() {
        return lottoGameNumbers.stream()
                               .map(lottoNum -> Integer.toString(lottoNum.getNumber()))
                               .collect(Collectors.joining(","));
    }

    public boolean isWinnerNumber(String winNumber) {
        return lottoGameNumbers.contains(new LottoNumber(winNumber));
    }

    private void lottoNumberValidationCheck() {
        if (islottoNumberWrongSize() || islottoNumberDuplicate()) {
            throw new IllegalStateException("로또 번호의 수가 6이 아니거나 중복된 숫자가 있습니다.");
        }
    }

    private boolean islottoNumberWrongSize() {
        return lottoGameNumbers.size() != InitEnum.LOTTO_DEFAULT_SIZE.value();
    }

    private boolean islottoNumberDuplicate() {
        return lottoGameNumbers.stream()
                               .distinct()
                               .count() != lottoGameNumbers.size();
    }

    public int winnerPrice(String lastWeekWinnerNumber, String bonusNumber) {
        return LottoEnum.findByPrice(
                winnerCheck(lastWeekWinnerNumber),
                isWinnerNumber(bonusNumber)
        ).price();
    }

}
