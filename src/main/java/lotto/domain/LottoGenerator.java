package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract class LottoGenerator {

    static List<Integer> generate() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        return lottoNumbers.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }
}
