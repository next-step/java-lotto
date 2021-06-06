package lotto.model;

import lotto.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("LottoGenerator를 통해 로또가 잘 생성 되는지 테스트")
    @Test
    void makeLottoTest() {
        assertThat(LottoGenerator.makeLotto().getClass()).isEqualTo(Lotto.class);
    }
}
