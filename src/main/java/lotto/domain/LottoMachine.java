package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    public static List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateRandomLotto());
        }
        return lottos;
    }

    private static Lotto generateRandomLotto() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return Lotto.of(lottoNumbers.subList(0, 6));
    }

}
