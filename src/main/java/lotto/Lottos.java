package lotto;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;

    public Lottos(int amount) {
        int n = amount/ LOTTO_PRICE;
        this.lottoList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            this.lottoList.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int lottosSize() {
        return this.lottoList.size();
    }


    public Map<Integer, Integer> getResult(Lotto winning) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int sameNumbers = lotto.getSameNumbers(winning);
            int count = result.getOrDefault(sameNumbers, 0);
            result.put(sameNumbers, count+1);
        }
        return result;
    }
}
