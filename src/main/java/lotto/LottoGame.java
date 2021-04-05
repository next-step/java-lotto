package lotto;

import lotto.exception.MoneyNotEnoughException;
import lotto.model.Lotto;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    OutputView outputView;
    List<Lotto> lottos;

    public LottoGame() {
        outputView = new OutputView();
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }



    public void buyLotto(int buyMoney) {
        int buyAmount = buyMoney/LOTTO_PRICE;
        if( buyAmount <= 0){
            throw new MoneyNotEnoughException("Money is not enough to buy lotto");
        }
        outputView.printBoughtLottoCount(buyAmount);

        for (int i = 0; i < buyAmount; i++) {
            Lotto lotto = new Lotto();
            lotto.createRandomNumber();
            outputView.printLottoNumbers(lotto);
            lottos.add(lotto);
        }
        outputView.printLine();
    }
}
