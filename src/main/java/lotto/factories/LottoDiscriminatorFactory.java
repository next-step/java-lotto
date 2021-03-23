package lotto.factories;

import lotto.domain.LottoDiscriminator;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoDiscriminatorFactory {
    public static LottoDiscriminator from(String[] winnerNumbers) {
        return new LottoDiscriminator(
                Arrays.stream(winnerNumbers)
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }
}
