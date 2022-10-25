package lotto.strategy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LottoCommonGenerateStrategy implements LottoGenerateStrategy{
    @Override
    public Set<Integer> generateLotto() {
        Set<Integer> tmpLottoNums = new TreeSet<>();
        while (tmpLottoNums.size() < MAX_SIZE) {
            int lottoNum = ThreadLocalRandom.current().nextInt(LOTTO_MIN_NUM, LOTTO_MAX_BOUND_NUM);
            tmpLottoNums.add(lottoNum);
        }
        return tmpLottoNums;
    }
}
