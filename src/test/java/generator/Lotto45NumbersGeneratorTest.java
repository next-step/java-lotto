package generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Lotto45NumbersGeneratorTest {

    @Test
    @DisplayName("1 ~ 45개의 수를 만든다.")
    void make_till_45() {
        LottoNumbersGenerator generator = new Lotto45NumbersGenerator();
        assertThat(generator.generate().size()).isEqualTo(45);
    }

    @Test
    @DisplayName("1 이 제일 작은 수이다.")
    void minimal_num_is_1() {
        LottoNumbersGenerator generator = new Lotto45NumbersGenerator();
        assertThat(generator.generate().get(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("45가 제일 큰 수이다.")
    void maximum_num_is_45() {
        LottoNumbersGenerator generator = new Lotto45NumbersGenerator();
        assertThat(generator.generate().get(44)).isEqualTo(45);
    }

}