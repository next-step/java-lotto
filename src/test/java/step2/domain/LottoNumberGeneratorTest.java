package step2.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberGeneratorTest {

    @Test
    void create() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumbers lottoNumbers = new SameLottoNumberGenerator(numbers).generate();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }

    @Test
    void createInvalid() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SameLottoNumberGenerator(numbers).generate());
    }
}