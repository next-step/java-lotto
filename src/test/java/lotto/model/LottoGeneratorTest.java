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
    @DisplayName("입력수량만큼 로또번호 리스트를 생성한다")
    void lottoList() {
        assertThat(generator.addLotto(10).size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또번호는 6개를 생성한다")
    void lottoNumQuantity() {
        assertThat(generator.createLotto().size()).isEqualTo(6);
    }
}