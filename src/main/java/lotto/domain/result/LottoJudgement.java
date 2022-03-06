package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningInfo;
import lotto.domain.winning.WinningNumbers;

public class LottoJudgement {

    private final List<LottoResult> lottoResults;

    public LottoJudgement(List<Lotto> lottos, WinningNumbers winningNumbers) {
        lottoResults = judge(lottos, winningNumbers);
    }

    public List<LottoResult> judge(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> new WinningInfo(lotto, winningNumbers))
                .map(winningInfo -> LottoResult.of(winningInfo.getCount(), winningInfo.getHasBonus()))
                .collect(Collectors.toList());
    }

    public List<LottoResult> getLottoResults() {
        return new ArrayList<>(lottoResults);
    }
}
