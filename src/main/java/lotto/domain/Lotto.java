package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        this.lottoNumbers.addAll(lottoNumbers.subList(0, 6));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
