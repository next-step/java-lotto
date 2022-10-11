package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    public static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> produces(LottoNumberProduceStrategy strategy, int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(produce(strategy, LOTTO_NUMBER_COUNT));
        }

        return lottos;
    }

    private Lotto produce(LottoNumberProduceStrategy strategy, int lottoNumberCount) {
        Set<Integer> lottoNumberBox = new HashSet<>();

        while (lottoNumberBox.size() != lottoNumberCount) {
            addIfNotExist(lottoNumberBox, strategy.produce());
        }

        return Lotto.of(new ArrayList<>(lottoNumberBox));
    }

    private void addIfNotExist(Set<Integer> lottoNumberBox, Integer lottoNumber) {
        if (!lottoNumberBox.contains(lottoNumber)) {
            lottoNumberBox.add(lottoNumber);
        }
    }
}
