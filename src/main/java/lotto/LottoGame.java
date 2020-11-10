package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    public static final String INVALID_AMOUNT_ERR_MSG = "amount의 값은 음수가 될 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER_ERR_MSG = "보너스번호는 당첨번호와 같을 수 없습니다.";

    private final View view;
    private final LottoService lottoService;

    public LottoGame(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void start() {
        int amount = getAmount();
        List<Lotto> boughtLottos = buyLottos(amount);
        if (boughtLottos.isEmpty()) {
            return;
        }
        WinningNumber winningNumber = getWinningNumber();
        printStatistic(winningNumber, boughtLottos);
    }

    private int getAmount() {
        int amount = view.getAmount();
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_ERR_MSG);
        }
    }

    private List<Lotto> buyLottos(int amount) {
        List<Lotto> boughtLottos = lottoService.buyLottos(amount);
        view.printBoughtLottos(boughtLottos);
        return boughtLottos;
    }

    private WinningNumber getWinningNumber() {
        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = LottoNumber.from(view.getBonusNumber());
        validateBonusNumber(winningLotto, bonusNumber);
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        return Lotto.of(view.getWinningNumbers());
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalStateException(INVALID_BONUS_NUMBER_ERR_MSG);
        }
    }

    private void printStatistic(WinningNumber winningNumber, List<Lotto> boughtLottos) {
        WinningStatistic winningStatistic = lottoService.getResult(winningNumber, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }
}
