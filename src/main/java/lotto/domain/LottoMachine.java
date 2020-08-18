package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, 5);
    }
}
