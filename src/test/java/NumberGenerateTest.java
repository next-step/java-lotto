import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import step2.NumberGenerateStrategy;
import step2.RandomStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGenerateTest {

    @Test
    void 로또_번호는_6개가_생성된다() {

        // given
        NumberGenerateStrategy strategy = new RandomStrategy();

        // when
        List<Integer> result = strategy.generate();

        // then
        assertThat(result).hasSize(6);
    }

    @Test
    void 로또_번호는_1에서_45_사이로_정렬되어있다() {

        // given
        NumberGenerateStrategy strategy = new RandomStrategy();

        // when
        List<Integer> result = strategy.generate();

        // then
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).isSorted();
            softAssertions.assertThat(result.get(0)).isGreaterThanOrEqualTo(1);
            softAssertions.assertThat(result.get(5)).isLessThanOrEqualTo(45);
        });
    }
}
