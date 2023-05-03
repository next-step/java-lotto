package lottoauto.domain;

import java.util.ArrayList;
import java.util.List;
import lottoauto.model.Constant;
import lottoauto.model.Lotto;
import lottoauto.model.Lottos;

public class LottoService {

    public Lottos generateLottoNumber(int amount) {
        int quantity = getQuantity(amount);
        amountValidation(amount);
        List<Lotto> lotto = generateLotto(quantity);
        return new Lottos(lotto);
    }

    private List<Lotto> generateLotto(int quantity) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lotto.add(new Lotto());
        }
        return lotto;
    }

    private void amountValidation(int amount) {
        if (amount < Constant.ONE_LOTTO_AMOUNT) {
            throw new IllegalArgumentException("로또 한개의 금액은 1000원 입니다.");
        }
    }

    public int getQuantity(int amount) {
        return amount / Constant.ONE_LOTTO_AMOUNT;
    }

}
