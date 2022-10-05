package lotto.step2.dto;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberDTOTest {
    public static final LottoNumberDTO LOTTO_NUMBER_DTO = new LottoNumberDTO(LottoNumberFixture.ONE.lottoNumberInformation().getLottoNumber());
    
    @Test
    @DisplayName("LottoNumberDTO 생성")
    void create() {
        assertThat(LottoNumberDTOTest.LOTTO_NUMBER_DTO).isNotNull();
    }
}