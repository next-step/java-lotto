package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalInputAmountException;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        List<Lotto> boughtLottos = buyLottos();
        if (boughtLottos.isEmpty()) {
            return;
        }
        printStatistic(boughtLottos);
    }

    private List<Lotto> buyLottos() {
        int amount = getAmount();
        int numberOfManualLotto = getNumberOfManualLotto(amount);
        List<Set<Integer>> manualLottoNumbers = getManualLottoNumbers(numberOfManualLotto);
        return getLottos(amount, manualLottoNumbers);
    }

    private int getAmount() {
        int amount = view.getAmount();
        validateAmount(amount);
        return amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new IllegalInputAmountException(INVALID_AMOUNT_ERR_MSG);
        }
    }

    private int getNumberOfManualLotto(int amount) {
        int numberOfManualLotto = view.getNumberOfManualLotto();
        lottoService.validateInput(amount, numberOfManualLotto);
        return numberOfManualLotto;
    }

    private List<Set<Integer>> getManualLottoNumbers(int numberOfManualLotto) {
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        if (numberOfManualLotto > 0) {
            manualLottoNumbers = view.getManualLottoNumbers(numberOfManualLotto);
        }
        return manualLottoNumbers;
    }

    private List<Lotto> getLottos(int amount, List<Set<Integer>> manualLottoNumbers) {
        List<Lotto> boughtLottos = lottoService.buyLottos(manualLottoNumbers, amount);
        view.printBoughtLottos(manualLottoNumbers.size(), boughtLottos);
        return boughtLottos;
    }

    private WinningNumber getWinningNumber() {
        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = LottoNumber.valueOf(view.getBonusNumber());
        validateBonusNumber(winningLotto, bonusNumber);
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        return Lotto.of(view.getWinningNumbers());
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalBonusNumberException(INVALID_BONUS_NUMBER_ERR_MSG);
        }
    }

    private void printStatistic(List<Lotto> boughtLottos) {
        WinningNumber winningNumber = getWinningNumber();
        WinningStatistic winningStatistic = lottoService.getResult(winningNumber, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }
}
