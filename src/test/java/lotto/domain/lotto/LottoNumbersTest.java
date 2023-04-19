package lotto.domain.lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final LottoNumbers lottoNumbers = new LottoNumbers();

        assertThat(lottoNumbers)
                .extracting("lottoNumbers")
                .isNotNull();
    }
}
