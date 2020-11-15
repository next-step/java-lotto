package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalInputAmountException;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;
import java.util.function.Supplier;

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
        int amount = getValidInput(() -> getAmount());
        int numberOfManualLotto = getValidInput(() -> getNumberOfManualLotto(amount));
        return getValidInput(() -> getLotto(amount, numberOfManualLotto));
    }

    public <T> T getValidInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            view.printInputError(e);
            return getValidInput(supplier);
        }
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

    private ManualLottoNumbers getManualLottoNumbers(int numberOfManualLotto) {
        if (numberOfManualLotto <= 0) {
            return ManualLottoNumbers.empty();
        }

        return view.getManualLottoNumbers(numberOfManualLotto);
    }

    private List<Lotto> getLotto(int amount, int numberOfManualLotto) {
        ManualLottoNumbers manualLottoNumbers = getValidInput(() -> getManualLottoNumbers(numberOfManualLotto));
        return getLottosWithManualNumbers(amount, manualLottoNumbers);
    }

    private List<Lotto> getLottosWithManualNumbers(int amount, ManualLottoNumbers manualLottoNumbers) {
        List<Lotto> boughtLottos = lottoService.buyLottos(manualLottoNumbers, amount);
        view.printBoughtLottos(manualLottoNumbers, boughtLottos);
        return boughtLottos;
    }

    private WinningNumber getWinningNumber() {
        Lotto winningLotto = getValidInput(() -> getWinningLotto());
        LottoNumber bonusNumber = getValidInput(() -> getBonusLottoNumber(winningLotto));
        return new WinningNumber(winningLotto, bonusNumber);
    }

    private LottoNumber getBonusLottoNumber(Lotto winningLotto) {
        LottoNumber bonusNumber = LottoNumber.valueOf(view.getBonusNumber());
        validateBonusNumber(winningLotto, bonusNumber);
        return bonusNumber;
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
