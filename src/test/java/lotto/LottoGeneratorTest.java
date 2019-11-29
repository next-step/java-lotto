package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("자동 로또 숫자 6개 생성")
    @Test
    void makeAutoNumbersTest() {
        assertThat(LottoGenerator.makeAutoNumbers().size()).isEqualTo(6);
    }
}
