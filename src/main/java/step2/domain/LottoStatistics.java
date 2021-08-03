package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final Integer MINIMAL_SUCCESS_NUMBER = 3;

    private final Map<Integer, Integer> resultOfLottos = new HashMap<>();
    private final LottoNumber winOfLottoNumber;

    public LottoStatistics(LottoNumber winOfLottoNumber) {
        this.winOfLottoNumber = winOfLottoNumber;
    }

    public void lottoOfStatistics(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.numbers().getNumbers();
            calculate(winOfLottoNumber.correctCount(numbers));
        }
    }

    private void calculate(int count) {
        if (count >= MINIMAL_SUCCESS_NUMBER) {
            resultOfLottos.put(count, resultOfLottos.getOrDefault(count, 0) + 1);
        }
    }

    public Map<Integer, Integer> calculate() {
        return resultOfLottos;
    }
}
