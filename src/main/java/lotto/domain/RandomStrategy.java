package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class RandomStrategy implements LottoNumberProduceStrategy {

    private final Supplier<Integer> numberSupplier;
    private final int count;

    public RandomStrategy(Supplier<Integer> numberSupplier, int count) {
        this.numberSupplier = numberSupplier;
        this.count = count;
    }

    @Override
    public List<Integer> getLottoNumber() {
        Set<Integer> lottoNumberBox = new HashSet<>();

        while (lottoNumberBox.size() != count) {
            add(lottoNumberBox, numberSupplier.get());
        }

        return new ArrayList<>(lottoNumberBox);
    }

    private void add(Set<Integer> lottoNumbers, Integer lottoNumber) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
