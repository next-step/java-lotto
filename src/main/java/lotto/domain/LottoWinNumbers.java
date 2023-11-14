package lotto.domain;

import lotto.strategy.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {

    private List<Integer> winningLottoNumbers;

    public LottoWinNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = new ArrayList<>(winningLottoNumbers);
    }

    public long matchCount(LottoGenerator lottoGenerator) {
        return lottoGenerator.lotto().stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }
}
