package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {
    private LottoGenerator() {
    }

    public static List<Lotto> auto(int count) {
        return IntStream.rangeClosed(1,count)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    public static List<Lotto> manual(List<List<Integer>> manualLottos) {
        return manualLottos.stream()
                .map(Lotto::create)
                .collect(Collectors.toList());
    }

    public static Lotto generateLotto() {
        List<Integer> cachedLottoNumber = LottoNumber.LOTTO_NUMBER_CACHE.keySet()
                                                                        .stream()
                                                                        .collect(Collectors.toList());
        Collections.shuffle(cachedLottoNumber);
        cachedLottoNumber = cachedLottoNumber.subList(0,6);
        Collections.sort(cachedLottoNumber);
        return Lotto.create(cachedLottoNumber);
    }
}
