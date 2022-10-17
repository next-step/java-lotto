package lotto.model;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lotto.Lotto;
import lotto.LottoMatchResult;

public class LottoNumbers {

    private final List<Lotto> lottos;

    public LottoNumbers(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoMatchResult> guess(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return lottos.stream()
                     .map(lotto -> lotto.match(winningNumber, bonusNumber))
                     .collect(toList());
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                     .map(Lotto::getNumbers)
                     .collect(toList());
    }
}
