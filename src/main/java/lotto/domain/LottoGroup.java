package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private static final int PRICE = 1000;
    private final List<Lotto> lottos;

    public LottoGroup(int money) {
        this(buyLotto(money));
    }
    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    private static List<Lotto> buyLotto(int money) {
        int cnt = money / PRICE;

        List<Lotto> lottoArray = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            lottoArray.add(new Lotto(LottoMachine.createLottoNumbers()));
        }

        return lottoArray;
    }
    public List<Lotto> getLottoNumbers() {
        return lottos;
    }
}
