package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Money money = new Money(InputView.readMoney());
        LottoSeller seller = new LottoSeller(new RandomLottoNumbersGenerator());
        Lottos lottos = seller.sell(money);
        OutputView.printLottos(lottos);

        Lotto winningLotto = new Lotto(new LottoNumbers(InputView.readNumbers()));
    }
}
