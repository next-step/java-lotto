package lotto.domain;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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
