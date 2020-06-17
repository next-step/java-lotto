package camp.nextstep.edu.nextstep8.lotto;

import java.util.List;

public class LottoWinnerNumber {
    private final List<Integer> winnerNumbers;

    public LottoWinnerNumber(String winnerNumbers) {
        this.winnerNumbers = StringLottoNumberConvertor.convert(winnerNumbers);
    }

    public int getMatchCount(LottoNumber lottoNumber) {
        int matchCount = (int) lottoNumber.getNumbers().stream()
                .filter(number -> winnerNumbers.contains(number))
                .count();

        return matchCount;
    }
}
