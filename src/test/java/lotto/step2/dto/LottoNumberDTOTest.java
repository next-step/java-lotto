package lotto.step2.dto;

import lotto.step2fixture.dto.LottoNumberDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberDTOTest {
    @Test
    @DisplayName("LottoNumberDTO 생성")
    void create() {
        assertThat(LottoNumberDTOFixture.LOTTO_NUMBER_DTO).isNotNull();
    }
}