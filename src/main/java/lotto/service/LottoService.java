package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.service.helper.LottoFactory;
import lotto.service.helper.WinningChecker;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class LottoService {
    public List<Lotto> buyLottos(List<Set<Integer>> manualLottoNumbers, int amount) {
        return LottoFactory.buyLottos(manualLottoNumbers, amount);
    }

    public WinningStatistic getResult(WinningNumber winningNumber, Collection<Lotto> boughtLottos) {
        return WinningChecker.getResult(winningNumber, boughtLottos);
    }

    public void validateInput(int amount, int numberOfManualLotto) {
        if (isInvalidAmountAndNumberOfManualLotto(amount, numberOfManualLotto)) {
            throw new IllegalArgumentException("입력된 금액보다 더 많은 로또를 구입 할 수 없습니다.");
        }
    }

    private boolean isInvalidAmountAndNumberOfManualLotto(int amount, int numberOfManualLotto) {
        return amount / LottoFactory.PRICE_OF_ONE_LOTTO < numberOfManualLotto;
    }
}
