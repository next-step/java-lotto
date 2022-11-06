package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    void setup() {
        generator = new LottoGenerator();
    }

    @Test
    @DisplayName("입력수량만큼 로또번호를 생성한다")
    void test() {
        assertThat(generator.addLotto(10).size()).isEqualTo(10);
    }
}