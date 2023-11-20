package lotto.strategy;

import lotto.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManualLottoGeneration implements LottoGeneration {
    private final List<Integer> list;

    public ManualLottoGeneration(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Set<LottoNumber> generate() {
        Set<LottoNumber> lottoSet = new HashSet<>();
        for (int number : list) {
            lottoSet.add(LottoNumber.valueOf(number));
        }
        return lottoSet;
    }
}
