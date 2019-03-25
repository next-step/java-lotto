package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoGameResult;
import lotto.vo.LottoMatchResult;
import lotto.vo.LottoWinResult;

import java.util.List;
import java.util.stream.Collectors;

public class LottoRunner {
    private LottoRunner() {
    }

    public static LottoGameResult runLotto(WinningLotto winner, LottoBundle lottoBundle) {
        List<LottoMatchResult> lottoMatchResults = getLottoMatchResults(winner, lottoBundle);
        List<LottoRank> lottoRanks = getLottoRanks(lottoMatchResults);

        return new LottoGameResult(new LottoWinResult(lottoRanks));
    }

    private static List<LottoMatchResult> getLottoMatchResults(WinningLotto winner, LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();

        return lottos.stream()
                .map(winner::getMatchResult)
                .collect(Collectors.toList());
    }

    private static List<LottoRank> getLottoRanks(List<LottoMatchResult> lottoMatchResults) {
        return lottoMatchResults.stream()
                .map(LottoRank::getRankOf)
                .collect(Collectors.toList());
    }
}
