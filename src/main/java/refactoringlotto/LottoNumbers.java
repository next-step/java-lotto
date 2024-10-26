package refactoringlotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    public static final int RANK_SUB_NUMBER = 7;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<Integer> lottoWinningList) {
        for (int winningNumber : lottoWinningList) {
            lottoNumbers.add(new LottoNumber(winningNumber));
        }
    }

    public int lottoRank(List<LottoNumber> lottoNumbers) {
        return RANK_SUB_NUMBER - (int) lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }
}
