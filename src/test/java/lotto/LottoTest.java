package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void LOTTO_NUMBER_COUNT() {
        assertThat(new Lotto(5).getLottoNumbers()).hasSize(5);
    }

}
