package step2.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    void create() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumbers lottoNumbers = new SameLottoNumberGenerator(numbers).generate();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }


}