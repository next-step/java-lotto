package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {

    private List<Integer> winningLottoNumbers;

    public LottoWinNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
    }

    public long matchCount(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }
}
