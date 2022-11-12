package lotto.application;

import lotto.domain.*;

import java.util.List;

public class LottoService {

    public Lottos purchaseLottos(PurchaseMoney purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(purchaseMoney);
        return lottoMachine.purchase();
    }

    public LottoStatistics statistics(List<Integer> numbers, Lottos lottos) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        return new LottoStatistics(lottos, winningNumbers);
    }

}
