package lotto.model;

import lotto.utility.LottoNumberGenerator;

import java.util.*;

public class Lottos {
    private final Map<Integer, List<Integer>> lottos;

    public Lottos() {
        lottos = new HashMap<>();
    }

    public void saveLotto(int count, List<Integer> lotto) {
        lottos.put(count, lotto);
    }

    public Map<Integer, List<Integer>> provideLottosInfo() {
        return lottos;
    }

}
