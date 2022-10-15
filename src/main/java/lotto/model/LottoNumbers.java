package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

import lotto.LottoMatchResult;
import lotto.Lotto;

public class LottoNumbers {

    private final List<Lotto> lottos;

    public LottoNumbers(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoMatchResult> guess(WinningNumber winningNumber) {
        return lottos.stream().map(lotto -> lotto.match(winningNumber)).collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList());
    }
}
