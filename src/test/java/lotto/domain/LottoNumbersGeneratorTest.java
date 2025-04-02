package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumbers.NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    public void randomLottoNumberTest() {
        LottoNumberGenerator generator = new LottoNumberGenerator();

        LottoNumbers lottoNumbers = generator.generate();

        List<Integer> values = lottoNumbers.numbers().stream()
                .map(LottoNumber::number)
                .collect(Collectors.toList());
        assertThat(values).hasSize(6);
        assertThat(values).allMatch(n -> n >= 1 && n <= 45);

        Set<Integer> uniqueValues = new HashSet<>(values);
        assertThat(uniqueValues).hasSize(6);
    }
}
