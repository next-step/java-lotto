package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final int MATCH_FIVE = 5;

    private final WinningLotto winningLottery;
    private final Lottos lottos;
    private List<Rank> resultStatistics = new ArrayList<>();

    public LottoStatistics(WinningLotto winningLottery, Lottos lottoList) {
        this.winningLottery = winningLottery;
        this.lottos = lottoList;
        this.resultStatistics = compareNumber();
    }

    private List<Rank> compareNumber() {
        for (int i = 0; i < lottos.getLottoLists().size(); i++) {
            int count = matchWinningNumbers(lottos.getLottoLists().get(i));
            resultStatistics.add(getRank(count, lottos.getLottoLists().get(i)));
        }
        return resultStatistics;
    }

    private Rank getRank(final int count, final Lotto lottoNumberList) {
        if (matchBonusNumber(count, lottoNumberList)) {
            return Rank.SECOND;
        }
        return Rank.getRank(count);
    }

    private boolean matchBonusNumber(final int count, final Lotto lottoNumberList) {
        return count == MATCH_FIVE && lottoNumberList.getLottoNumbers()
            .contains(winningLottery.getBonusNumber());
    }

    private int matchWinningNumbers(final Lotto lottoNumberList) {
        return lottoNumberList.getLottoNumbers().stream()
            .filter(x -> isWinningNumber(x))
            .collect(Collectors.toSet()).size();
    }

    private boolean isWinningNumber(final LottoNumber lottoNumber) {
        return winningLottery.getWinningNumber().getLottoNumbers().contains(lottoNumber);
    }

    public List<Rank> getResultStatistics() {
        return Collections.unmodifiableList(resultStatistics);
    }
}
