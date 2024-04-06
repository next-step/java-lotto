package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PassiveLottoMaker implements LottoMaker {

    private static final String SPLIT_TOKEN = ",";

    private final List<String> lottoNumbers;
    public PassiveLottoMaker(List<String> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Lotto> create() {
        return lottoNumbers.stream()
                .map(numbers -> Arrays.stream(numbers.split(SPLIT_TOKEN))
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::from)
                        .collect(Collectors.toList()))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
