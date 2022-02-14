package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final int MATCH_FIVE = 5;

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;
    private List<Rank> winningRanks = new ArrayList<>();
    private final Lottos lottos;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber, Lottos lottos) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    private void validate(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.getLottoNumbers().contains(bonusNumber.getLottoNumber())) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }

    public List<Rank> matchRank() {
        for (int i = 0; i < lottos.getLottoLists().size(); i++) {
            int count = matchWinningNumbers(lottos.getLottoLists().get(i));
            winningRanks.add(getRank(count, lottos.getLottoLists().get(i)));
        }
        return winningRanks;
    }

    private Rank getRank(final int count, final Lotto lottoNumberList) {
        if (matchBonusNumber(count, lottoNumberList)) {
            return Rank.SECOND;
        }
        return Rank.getRank(count);
    }

    private boolean matchBonusNumber(final int count, final Lotto lottoNumberList) {
        return count == MATCH_FIVE && lottoNumberList.getLottoNumbers()
            .contains(bonusNumber);
    }

    private int matchWinningNumbers(final Lotto lottoNumberList) {
        return lottoNumberList.getLottoNumbers().stream()
            .filter(lottoNumber -> isWinningNumber(lottoNumber))
            .collect(Collectors.toSet()).size();
    }

    private boolean isWinningNumber(final LottoNumber lottoNumber) {
        return winningNumber.getLottoNumbers().contains(lottoNumber);
    }

    public List<Rank> getWinningRanks() {
        return winningRanks;
    }

}
