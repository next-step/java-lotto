package lotto;

import lotto.model.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    void setup() {
        generator = new LottoGenerator(10);
    }

    @Test
    @DisplayName("입력수량만큼 로또번호를 생성한다")
    void test() {
        assertThat(generator.addLotto(10).size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또는 6자리 번호를 생성한다")
    void test2() {
        assertThat(generator.createLotto().size()).isEqualTo(6);
    }
}