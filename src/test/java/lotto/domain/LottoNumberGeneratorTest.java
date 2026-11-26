package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @DisplayName("생성한 숫자는 모두 1~45 사이다.")
    @Test
    public void test_1() {
        List<Integer> numbers = new LottoNumberGenerator().generate();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("생성한 숫자는 6개다.")
    @Test
    public void test_2() {
        List<Integer> numbers = new LottoNumberGenerator().generate();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("생성한 숫자에는 중복이 없다.")
    @Test
    public void test_3() {
        List<Integer> numbers = new LottoNumberGenerator().generate();
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @DisplayName("생성한 숫자는 오름차순이다.")
    @Test
    public void test_4() {
        List<Integer> numbers = new LottoNumberGenerator().generate();
        assertThat(numbers).isSorted();
    }
}
