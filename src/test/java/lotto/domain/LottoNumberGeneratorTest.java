package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoNumberGenerator;

public class LottoNumberGeneratorTest {

    @Test
    void 로또번호는_6개의_숫자이며_중복되지않는다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }


    @Test
    void 로또번호는_1부터_45까지의_숫자이다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        assertThat(numbers.stream().allMatch(number -> number >= 1 && number <= 45)).isTrue();
    }
}
