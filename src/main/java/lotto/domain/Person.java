package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person {
    private final int amount;
    private final List<Lotto> lottos;

    public Person(int amount) {
        this(amount, new ArrayList<>());
    }

    public Person(int amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public void buy() {
        lottos.add(new Lotto(LottoNumber.of()));
    }

    public LottoResult lottoResult(LottoNumber winningNumber) {
        LottoResult lottoResult = new LottoResult(new HashMap<>());
        for (Lotto lotto : lottos) {
            lottoResult.add(lotto.matchedCount(winningNumber.lottoNumber()));
        }
        return lottoResult;
    }

    public int amount() {
        return amount;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int numberOfLotto() {
        return lottos.size();
    }

}
