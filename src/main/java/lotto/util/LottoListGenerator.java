package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoListGenerator {
    private static final List<LottoNumber> lottoNumbersPool = new ArrayList<>();

    static {
        IntStream.rangeClosed(1, 45)
                .forEach(number -> lottoNumbersPool.add(new LottoNumber(number)));
    }

    public static List<Lotto> creatLottos(int ticketNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, ticketNumber)
                .forEach(idx -> lottoList.add(new Lotto(createLottoNumbers())));
        return lottoList;
    }

    private static Set<LottoNumber> createLottoNumbers() {
        Collections.shuffle(lottoNumbersPool);
        return lottoNumbersPool.stream().limit(6).collect(Collectors.toSet());
    }
}
