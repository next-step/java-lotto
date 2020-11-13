package lotto.utils;

import lotto.asset.LottoConst;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Shuffler {
    List<Integer> lottoNos;

    private Shuffler() {
        lottoNos = new LinkedList<>();
        int max = LottoConst.NO_MAX;
        int min = LottoConst.NO_MIN;
        for (int i = min; i <= max; i++) {
            lottoNos.add(i);
        }
    }

    public static Shuffler getInstance() {
        return SingletonHelper.instance;
    }

    private void shuffle() {
        Collections.shuffle(lottoNos);
    }

    public List<Integer> getLottoNos() {
        shuffle();
        return lottoNos.subList(0, LottoConst.NUM_OF_LOTTO_NO);
    }

    private static class SingletonHelper {
        private static final Shuffler instance = new Shuffler();
    }
}
