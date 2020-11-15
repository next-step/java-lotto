package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.exception.IllegalBonusNumberException;
import lotto.service.helper.ValidInputHelper;
import lotto.service.helper.WinningChecker;
import lotto.view.View;

import java.util.List;

public class StatisticPrinter {
    public static final String INVALID_BONUS_NUMBER_ERR_MSG = "보너스번호는 당첨번호와 같을 수 없습니다.";

    private final View view;

    public StatisticPrinter(View view) {
        this.view = view;
    }

    public void printStatistic(List<Lotto> boughtLottos) {
        WinningNumber winningNumber = getWinningNumber();
        WinningStatistic winningStatistic = WinningChecker.getResult(winningNumber, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }

    private WinningNumber getWinningNumber() {
        Lotto winningLotto = ValidInputHelper.get(() -> getWinningLotto(), view::printInputError);
        LottoNumber bonusNumber = ValidInputHelper.get(() -> getBonusLottoNumber(winningLotto), view::printInputError);
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        return Lotto.of(view.getWinningNumbers());
    }

    private LottoNumber getBonusLottoNumber(Lotto winningLotto) {
        LottoNumber bonusNumber = LottoNumber.valueOf(view.getBonusNumber());
        validateBonusNumber(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalBonusNumberException(INVALID_BONUS_NUMBER_ERR_MSG);
        }
    }
}
