package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoGeneratorTest {
    @Test
    void 로또_번호_생성기가_원하는_범위에서_생기는지_확인() {
        assertThat(new LottoGenerator(1, 6).equals(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    void 로또_번호_생성기의_범위를_잘못_입력() {
        assertThatThrownBy(() -> {
            new LottoGenerator(2, 1).generate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_생성기의_범위를_잘못_입력2() {
        assertThatThrownBy(() -> {
            new LottoGenerator(0, 1).generate();
        }).isInstanceOf(IllegalArgumentException.class);
    }

}