package lotto;

import lotto.domain.CanNotBuyLottoException;
import lotto.domain.Cashier;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Cashier cashier = createCashier();
        int playLottoCount = cashier.findCountOfPlayLotto();
        List<LottoNumber> lottoNumbers = LottoNumbersGenerator.generate(playLottoCount);

        OutputView.printGeneratedLottoNumbers(lottoNumbers);


    }

    private static Cashier createCashier() {
        try {
            return new Cashier(InputView.receiveMoney());
        } catch (CanNotBuyLottoException e) {
            System.out.println(e.getMessage());
            return createCashier();
        }
    }
}
