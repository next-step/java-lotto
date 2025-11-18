package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    @Test
    void 랜덤_로또_번호_6개를_생성한다() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        assertThat(numbers).hasSize(6);
    }

    @Test
    void 생성된_번호는_1부터_45사이_값이다() {
        LottoNumberGenerator generator = new LottoNumberGenerator();

        List<Integer> numbers = generator.generate();

        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @Test
    void 생성된_번호는_중복되지_않는다() {
        List<Integer> numbers = LottoNumberGenerator.generate();

        assertThat(numbers).doesNotHaveDuplicates();
    }
}
