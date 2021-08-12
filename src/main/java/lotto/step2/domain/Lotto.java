package lotto.step2.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private List<LottoTicket> lotto;

    public Lotto(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 "+LOTTO_PRICE+"원입니다.");
        }
        this.lotto = new ArrayList<>();
        for (int i = 0; i < money; i++) {
            buyLotto(LottoMachine.mixLottoNumbers());
        }
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public void buyLotto(List<LottoNumber> lottoNumbers) {
        lotto.add(new LottoTicket(lottoNumbers));
    }

    public List<LottoTicket> getLotto() {
        return lotto;
    }

    public void matchLotto(LottoResult lottoResult) {
        for (LottoTicket lottoTicket : this.lotto) {
            lottoResult.checkLottoTicket(lottoTicket);
        }
    }
}
