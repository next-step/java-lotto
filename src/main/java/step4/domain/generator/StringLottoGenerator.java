package step4.domain.generator;

import step4.domain.Lotto;
import step4.domain.LottoNumber;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringLottoGenerator implements LottoGenerator {

    private final String lottoString;

    public StringLottoGenerator(String lottoString) {
        this.lottoString = lottoString;
    }

    @Override
    public Lotto generate() {
        return Arrays.stream(lottoString.split(","))
                .map(LottoNumber::of)
                .collect(collectingAndThen(toList(), Lotto::of));
    }
}
