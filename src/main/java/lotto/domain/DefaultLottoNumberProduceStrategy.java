package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class DefaultLottoNumberProduceStrategy implements LottoNumberProduceStrategy {

    @Override
    public List<Integer> getLottoNumber(Supplier<Integer> strategy, int produceCount) {
        Set<Integer> lottoNumberBox = new HashSet<>();

        while (lottoNumberBox.size() != produceCount) {
            add(lottoNumberBox, strategy.get());
        }

        return new ArrayList<>(lottoNumberBox);
    }

    private void add(Set<Integer> lottoNumbers, Integer lottoNumber) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
