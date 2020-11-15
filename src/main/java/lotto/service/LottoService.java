package lotto.service;

import lotto.domain.Lotto;
import lotto.dto.Amount;
import lotto.dto.ManualLottoNumbers;
import lotto.dto.NumberOfManualLotto;
import lotto.service.helper.LottoFactory;
import lotto.service.helper.ValidInputHelper;
import lotto.view.View;

import java.util.List;

public class LottoService {
    private final View view;

    public LottoService(View view) {
        this.view = view;
    }

    public List<Lotto> buyLottos() {
        Amount amount = ValidInputHelper.get(() -> Amount.valueOf(view.getAmount()), view::printInputError);
        NumberOfManualLotto numberOfManualLotto = ValidInputHelper.get(() -> getNumberOfManualLotto(amount), view::printInputError);
        return ValidInputHelper.get(() -> getLotto(amount, numberOfManualLotto), view::printInputError);
    }

    private NumberOfManualLotto getNumberOfManualLotto(Amount amount) {
        NumberOfManualLotto numberOfManualLotto = NumberOfManualLotto.valueOf(view.getNumberOfManualLotto());
        numberOfManualLotto.validateSize(amount);
        return numberOfManualLotto;
    }

    private List<Lotto> getLotto(Amount amount, NumberOfManualLotto numberOfManualLotto) {
        ManualLottoNumbers manualLottoNumbers = ValidInputHelper.get(() -> getManualLottoNumbers(numberOfManualLotto), view::printInputError);
        return getLottosWithManualNumbers(amount, manualLottoNumbers);
    }

    private ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        if (numberOfManualLotto.isZero()) {
            return ManualLottoNumbers.empty();
        }

        return view.getManualLottoNumbers(numberOfManualLotto);
    }

    private List<Lotto> getLottosWithManualNumbers(Amount amount, ManualLottoNumbers manualLottoNumbers) {
        List<Lotto> boughtLottos = LottoFactory.buyLottos(manualLottoNumbers, amount);
        view.printBoughtLottos(manualLottoNumbers, boughtLottos);
        return boughtLottos;
    }
}