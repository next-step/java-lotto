package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<Lotto>();

    public Lottos() {
    }

    public void buyLotto(int number, LottoGenerator lottoGenerator) {
        for (int i = 0; i < number; i++) {
            lottos.add(lottoGenerator.generateLottos());
        }
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public String allPurchasedLottoNumber() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.lottoNumber() + "\n");
        }
        return sb.toString();
    }

    public Lotto getLotto(int number) {
        return lottos.get(number);
    }
}
