package lotto.strategy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LottoCommonGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public List<Integer> generateLotto() {
        TreeSet<Integer> tmpLottoNums = new TreeSet<>();
        while (tmpLottoNums.size() < MAX_SIZE) {
            int lottoNum = ThreadLocalRandom.current().nextInt(LOTTO_MIN_NUM, LOTTO_MAX_BOUND_NUM);
            tmpLottoNums.add(lottoNum);
        }
        return new ArrayList<>(tmpLottoNums);
    }
}
