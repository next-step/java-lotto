package lotto.domain.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.user.UserLotto;
import lotto.domain.user.UserLottos;
import lotto.domain.winning.WinningBalls;
import lotto.dto.WinningInfo;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(UserLottos userLottos, WinningBalls winningBalls) {
        lottoResults = judge(userLottos.getRawUserLottos(), winningBalls);
    }

    public List<LottoResult> judge(List<UserLotto> userLottos, WinningBalls winningBalls) {

        List<WinningInfo> winningInfos = userLottos.stream()
            .map(winningBalls::getWinningInfoOf)
            .collect(Collectors.toList());

        return winningInfos.stream()
            .map(LottoResult::of)
            .collect(Collectors.toList());
    }

    public List<LottoResult> getRawLottoResults() {
        return new ArrayList<>(lottoResults);
    }
}
