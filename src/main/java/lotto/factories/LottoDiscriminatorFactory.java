package lotto.factories;

import lotto.domain.LottoDiscriminator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoDiscriminatorFactory {
    public static LottoDiscriminator from(String[] winningNumbers) {
        return new LottoDiscriminator(
                new LottoTicket(
                        Arrays.stream(winningNumbers)
                                .map(String::trim)
                                .mapToInt(Integer::parseInt)
                                .mapToObj(LottoNumber::new)
                                .collect(Collectors.toList())
                )
        );
    }
}
