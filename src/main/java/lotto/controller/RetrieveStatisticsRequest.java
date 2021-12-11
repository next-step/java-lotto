package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Objects;

public class RetrieveStatisticsRequest {
    private final Lottos lottos;
    private final List<Integer> winningLottoNumbers;

    private RetrieveStatisticsRequest(Lottos lottos, List<Integer> winningLottoNumbers) {
        validateLottosAndWinningLottoNumbers(lottos, winningLottoNumbers);
        this.lottos = lottos;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public static RetrieveStatisticsRequest of(Lottos lottos, List<Integer> readWinningLottoNumbers) {
        return new RetrieveStatisticsRequest(lottos, readWinningLottoNumbers);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto winningLotto() {
        return new Lotto(new LottoNumbers(winningLottoNumbers));
    }

    private void validateLottosAndWinningLottoNumbers(Lottos lottos, List<Integer> winningLottoNumbers) {
        validateLottos(lottos);
        validateWinningLottoNumbers(winningLottoNumbers);
    }

    private void validateLottos(Lottos lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("lottos가 null입니다.");
        }
    }

    private void validateWinningLottoNumbers(List<Integer> winningLottoNumbers) {
        if (Objects.isNull(winningLottoNumbers)) {
            throw new IllegalArgumentException("winningLottoNumbers가 null입니다.");
        }
        if (winningLottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("winningLottoNumbers의 사이즈가 0입니다.");
        }
    }
}
