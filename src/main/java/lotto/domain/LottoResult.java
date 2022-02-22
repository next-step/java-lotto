package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    private final HashMap<String, Integer> resultMap = new HashMap<String, Integer>() {{
        LottoGrade.toList()
            .forEach(lottoDescription -> put(lottoDescription.getName(), 0));
    }};

    public int getCount(String name) {
        return resultMap.get(name);
    }

    public void upCount(String name) {
        if (!name.equals(LottoGrade.NOMATCH.getName())) {
            resultMap.put(name, resultMap.get(name) + 1);
        }
    }

    public double calculateYield(Money money) {
        double profit = LottoGrade.toList().stream()
            .mapToDouble(lottoDescription -> getCount(lottoDescription.getName())
                * lottoDescription.getWinningPrice())
            .sum();
        return profit / money.getMoney();
    }
}
