package lotto;

import java.util.Optional;

public interface LottoWinningStrategy {
    Optional<RANK> calculateWinningResult(SelectedLottoes selectedLottoes);
}
