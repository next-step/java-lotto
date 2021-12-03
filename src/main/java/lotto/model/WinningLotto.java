package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(List<String> winningNumbers, LottoNumber bonusNumber) {
        return new WinningLotto(makeLotto(winningNumbers), bonusNumber);
    }

    private static Lotto makeLotto(List<String> winningNumbers) {
        return new Lotto(winningNumbers.stream()
                                       .map(LottoNumber::new)
                                       .collect(Collectors.toList()));
    }

    public Result makeResult(Lottos lottos) {
        Result result = new Result();
        lottos.getLottos()
              .stream()
              .map(this::makeRank)
              .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }

    private Rank makeRank(Lotto target) {
        return Rank.from(target.matchCount(lotto), target.contains(bonusNumber));
    }
}
