package refactoringlotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<Integer> lottoWinningList) {
        for(int winningNumber :lottoWinningList) {
            lottoNumbers.add(new LottoNumber(winningNumber));
        }
    }

    public int lottoMatchCount(List<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }
}
