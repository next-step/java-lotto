package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final int MATCH_FIVE = 5;

    private final WinningLottery winningLottery;
    private final List<Lotto> lottoList;
    private List<Rank> resultStatistics = new ArrayList<>();

    public LottoStatistics(WinningLottery winningLottery, List<Lotto> lottoList) {
        this.winningLottery = winningLottery;
        this.lottoList = lottoList;
        this.resultStatistics = compareNumber();
    }

    private List<Rank> compareNumber() {
        for (int i = 0; i < lottoList.size(); i++) {
            int count = matchWinningNumbers(lottoList.get(i));
            resultStatistics.add(getRank(count, lottoList.get(i)));
        }
        return resultStatistics;
    }

    private Rank getRank(final int count, final Lotto lottoNumberList) {
        if (matchBonusNumber(count, lottoNumberList)) {
            return Rank.SECOND;
        }
        return Rank.getRank(count);
    }

    private int matchWinningNumbers(final Lotto lottoNumberList) {
        return lottoNumberList.getLottoNumber().stream()
            .filter(x -> isWinningNumber(x))
            .collect(Collectors.toSet()).size();
    }

    private boolean matchBonusNumber(final int count, final Lotto lottoNumberList) {
        return count == MATCH_FIVE && lottoNumberList.getLottoNumber()
            .contains(winningLottery.getBonusNumber());
    }

    private boolean isWinningNumber(final LottoNumber lottoNumber) {
        return winningLottery.getWinningNumber().getLottoNumber().contains(lottoNumber);
    }

    public List<Rank> getResultStatistics() {
        return Collections.unmodifiableList(resultStatistics);
    }
}
