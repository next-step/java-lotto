package lotto.core;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LottoCommonGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public List<Integer> generateLotto() {
        Set<Integer> tmpLottoNums = new HashSet<>();
        while (tmpLottoNums.size() < MAX_SIZE) {
            int lottoNum = ThreadLocalRandom.current().nextInt(LOTTO_MIN_NUM, LOTTO_MAX_NUM);
            tmpLottoNums.add(lottoNum);
        }
        List<Integer> result = new ArrayList<>(tmpLottoNums);
        Collections.sort(result);
        return result;
    }
}
