package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottosGeneratorTest {
    @Test
    @DisplayName("수동 로또 생성기는 문자열 입력값을 통해 로또를 생성한다.")
    void generate() {
        assertThat(new ManualLottosGenerator(List.of(
                "1,2,3,4,5,6",
                "38,39,40,41,42,43"
        )).generate().size()).isEqualTo(2);
    }
}