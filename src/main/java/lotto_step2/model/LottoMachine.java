package lotto_step2.model;

import java.util.*;

import static lotto_step2.LottoConstants.LOTTO_LIMIT_NUMBER;
import static lotto_step2.LottoConstants.LOTTO_LIMIT_SIZE;

public class LottoMachine {
    public List<Integer> createRandomList() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != LOTTO_LIMIT_SIZE) {
            set.add(getRandom());
        }

        List<Integer> createdLottos = new ArrayList<>(set);
        return createdLottos;
    }

    private int getRandom() {
        return new Random().nextInt(LOTTO_LIMIT_NUMBER) + 1;
    }
}
