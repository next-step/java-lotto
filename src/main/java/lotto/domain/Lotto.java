package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_SIZE = 6;

    private final List<Integer> lottoList;

    public Lotto() {
        this.lottoList = generatorLotto(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);
    }

    public List<Integer> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    private List<Integer> generatorLotto(int minNumber, int maxNumber) {
        List<Integer> lottoList = new ArrayList<>();

        for (int i = minNumber; i <= maxNumber; i++) {
            lottoList.add(i);
        }
        Collections.shuffle(lottoList);

        return lottoList.stream()
            .limit(LOTTO_MAX_SIZE)
            .collect(Collectors.toList());
    }
}
