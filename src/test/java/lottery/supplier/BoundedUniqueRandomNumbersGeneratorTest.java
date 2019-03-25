package lottery.supplier;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoundedUniqueRandomNumbersGeneratorTest {

    @Test
    public void test_중복없는_랜덤숫자_생성_범위제한() {
        final int lowerBoundInclusive = 1;
        final int upperBoundInclusive = 1000;
        final int size = 1000;
        final NumbersGenerator boundedUniqueNumbersGenerator =
                new BoundedUniqueRandomNumbersGenerator(lowerBoundInclusive, upperBoundInclusive);

        assertThat(boundedUniqueNumbersGenerator.nextNumbers(size))
                .hasSize(size)
                .doesNotHaveDuplicates()
                .allMatch(i -> i >= lowerBoundInclusive && i <= upperBoundInclusive);
    }
}