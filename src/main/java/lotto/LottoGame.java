package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.Amount;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.NumberOfManualLotto;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;
import lotto.exception.IllegalBonusNumberException;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;
import java.util.function.Supplier;

public class LottoGame {
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
        Amount amount = getValidInput(() -> Amount.valueOf(view.getAmount()));
        NumberOfManualLotto numberOfManualLotto = getValidInput(() -> getNumberOfManualLotto(amount));
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

    private NumberOfManualLotto getNumberOfManualLotto(Amount amount) {
        NumberOfManualLotto numberOfManualLotto = NumberOfManualLotto.valueOf(view.getNumberOfManualLotto());
        numberOfManualLotto.validateSize(amount);
        return numberOfManualLotto;
    }

    private ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        if (numberOfManualLotto.isZero()) {
            return ManualLottoNumbers.empty();
        }

        return view.getManualLottoNumbers(numberOfManualLotto);
    }

    private List<Lotto> getLotto(Amount amount, NumberOfManualLotto numberOfManualLotto) {
        ManualLottoNumbers manualLottoNumbers = getValidInput(() -> getManualLottoNumbers(numberOfManualLotto));
        return getLottosWithManualNumbers(amount, manualLottoNumbers);
    }

    private List<Lotto> getLottosWithManualNumbers(Amount amount, ManualLottoNumbers manualLottoNumbers) {
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
