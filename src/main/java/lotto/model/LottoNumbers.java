package lotto.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lotto.Lottos;
import lotto.LottoMatchResult;

public class LottoNumbers {

    private final List<Lottos> lottos;

    public LottoNumbers(List<Lottos> lottos) {
        this.lottos = lottos;
    }

    public List<LottoMatchResult> guess(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return lottos.stream()
                     .map(lotto -> lotto.match(winningNumber, bonusNumber))
                     .collect(toList());
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                     .map(Lottos::getNumbers)
                     .collect(toList());
    }
}
