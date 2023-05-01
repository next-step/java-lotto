package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int purchaseAmount) {
        this(purchaseAmount, new SimpleNumberGenerator());
    }

    public Lottos(int purchaseAmount, NumberGenerator numberGenerator) {
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(numberGenerator.generateNumbers()));
        }
    }

    public Lottos(List<Lotto> lottoList) {
        lottos.addAll(lottoList);
    }

    public int getAmount() {
        return lottos.size();
    }

    public Map<Integer, Integer> getResult(List<Integer> winningNumbers) {
        Map<Integer, Integer> lottoResultMap = initResult();
        for (Lotto lotto : lottos) {
            int numberOfMatched = lotto.getResult(winningNumbers);
            lottoResultMap.put(numberOfMatched, lottoResultMap.get(numberOfMatched) + 1);
        }
        return lottoResultMap;
    }

    private Map<Integer, Integer> initResult() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 6; i++) {
            map.put(i, 0);
        }
        return map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
