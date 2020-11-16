package lotto;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoNumbers;
import lotto.domain.NumberOfManualLotto;
import lotto.helper.LottoFactory;
import lotto.helper.ValidInputHelper;
import lotto.view.View;

public class LottoService {
    private final View view;

    public LottoService(View view) {
        this.view = view;
    }

    public Lottos buyLottos() {
        Amount amount = ValidInputHelper.get(() -> Amount.valueOf(view.getAmount()), view::printInputError);
        NumberOfManualLotto numberOfManualLotto = ValidInputHelper.get(() -> getNumberOfManualLotto(amount), view::printInputError);
        return ValidInputHelper.get(() -> getLotto(amount, numberOfManualLotto), view::printInputError);
    }

    private NumberOfManualLotto getNumberOfManualLotto(Amount amount) {
        NumberOfManualLotto numberOfManualLotto = ValidInputHelper.get(() -> NumberOfManualLotto.valueOf(view.getNumberOfManualLotto()), view::printInputError);
        numberOfManualLotto.validateSize(amount);
        return numberOfManualLotto;
    }

    private Lottos getLotto(Amount amount, NumberOfManualLotto numberOfManualLotto) {
        ManualLottoNumbers manualLottoNumbers = ValidInputHelper.get(() -> getManualLottoNumbers(numberOfManualLotto), view::printInputError);
        return getLottosWithManualNumbers(amount, manualLottoNumbers);
    }

    private ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        if (numberOfManualLotto.isZero()) {
            return ManualLottoNumbers.empty();
        }

        return view.getManualLottoNumbers(numberOfManualLotto);
    }

    private Lottos getLottosWithManualNumbers(Amount amount, ManualLottoNumbers manualLottoNumbers) {
        Lottos boughtLottos = LottoFactory.buyLottos(manualLottoNumbers, amount);
        view.printBoughtLottos(manualLottoNumbers, boughtLottos);
        return boughtLottos;
    }
}