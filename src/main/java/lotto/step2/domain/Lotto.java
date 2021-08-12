package lotto.step2.domain;

import java.util.*;

public class Lotto {
    private List<LottoTicket> lotto;

    public Lotto(int lottoCount) {
        this.lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
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
