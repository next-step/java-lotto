package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoGameNumGeneratorTest {
    @Test
    public void 로또_숫자_범위는_1부터_45까지다() {
        //when
        int[] numbers = LottoNumGenerator.generateNumbers();
        //then
        for (int number : numbers) {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        }
    }

    @Test
    public void 생성된_로또_숫자_갯수는_6개다() {
        //when
        int[] numbers = LottoNumGenerator.generateNumbers();
        //then
        assertThat(numbers).hasSize(6);
    }
}
