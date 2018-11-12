package domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    public void 로또_번호를_반환한다() {
        List<LottoNumber> numbers = LottoNumberGenerator.generateNumbers();

        assertThat(numbers).hasSize(6);
    }
}