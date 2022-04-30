package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("생성된 로또 번호 개수가 6개이다")
    void generateLotto() {
        assertThat(LottoGenerator.generate().isSize(6)).isTrue();
    }

}
