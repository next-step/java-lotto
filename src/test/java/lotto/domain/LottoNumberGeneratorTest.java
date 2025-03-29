package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void randomLottoNumberTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();

        LottoNumber lottoNumber = generator.generate();

        assertThat(
                lottoNumber.numbers()
                        .stream()
                        .distinct()
                        .filter(n -> n > 0 && n < 46)
                        .collect(Collectors.toList())
        ).hasSize(6);
    }
}
