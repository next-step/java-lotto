package step2.domain;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumbers;

import java.util.List;
import java.util.Map;

import static step2.LottoNumberGenerator.*;

public class LottoGame {
    private Lotto lotto = new Lotto();
    private static final int LOTTO_PRICE = 1000;

    public LottoGame(Request request) {
        this.buyLotto(request);
    }

    private void buyLotto(Request request) {
        int totalQuantity = request.getPurchaseMoney() / LOTTO_PRICE;
        for (int quantity = 1; quantity <= totalQuantity; quantity++) {
            lotto.addLottoNumber(new LottoNumbers(provideLottoNumbers()));
        }
    }

    public List<LottoNumbers> getLotto() {
        return lotto.getLotto();
    }

    public Map<Rank, List<Rank>> getWinLotto(List<Integer> targetNumbers) {
        return lotto.getWinLotto(targetNumbers);
    }
}
