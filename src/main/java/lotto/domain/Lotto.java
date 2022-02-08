package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_SIZE = 6;

    private final List<Integer> lottoList;

    public Lotto() {
        this.lottoList = generatorLotto();
    }

    public List<Integer> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    private int generatorNumber(int min, int max) {
        return new Random().nextInt(max + min) + max;
    }

    private List<Integer> generatorLotto() {
        List<Integer> lottoList = new ArrayList<>();

        while (lottoList.size() < LOTTO_MAX_SIZE) {
            lottoList.add(generatorNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }

        return lottoList;
    }
}