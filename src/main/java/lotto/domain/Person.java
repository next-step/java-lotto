package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private int amount;
    private List<Lotto> lottos = new ArrayList<>();

    public Person(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public void buy() {
        lottos.add(new Lotto(LottoNumber.of()));
    }

    public Map<Integer, Integer> findWinningResult(List<Integer> winningLottoNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int key = lotto.getWinningCount(winningLottoNumbers);
            result.put(key, result.getOrDefault(key, 0) + 1);
        }

        return result;
    }

}
