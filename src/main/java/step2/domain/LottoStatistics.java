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
        List<Integer> winOfLottoNumbers = winOfLottoNumber.getNumbers();

        int count = 0;

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.numbers();
            for (Integer number : numbers) {
                if (winOfLottoNumbers.contains(number)) {
                    count++;
                }
            }

            if (count >= MINIMAL_SUCCESS_NUMBER) {
                resultOfLottos.put(count, resultOfLottos.getOrDefault(count, 0) + 1);
            }
            count = 0;
        }
    }

    public Map<Integer, Integer> resultOfLotto() {
        return resultOfLottos;
    }
}
