package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoGenerateStrategy;
import step2.infrastructure.RandomStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGenerateTest {

    @Test
    void 로또_번호는_6개가_생성된다() {

        // given
        LottoGenerateStrategy strategy = new RandomStrategy();

        // when
        List<Integer> result = strategy.generate();

        // then
        assertThat(result).hasSize(6);
    }

    @Test
    void 로또_번호는_1에서_45_사이의_수다() {

        // given
        LottoGenerateStrategy strategy = new RandomStrategy();

        // when
        List<Integer> result = strategy.generate();

        // then
        assertThat(result).allSatisfy(number -> assertThat(number).isBetween(1, 45));
    }
}
