package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCreationRequestDtoTest {

    @DisplayName("LottoCreationRequestDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 15000;

        // when
        LottoCreationRequestDto lottoCreationRequestDto = LottoCreationRequestDto.newInstance(inputValue);

        // then
        assertThat(lottoCreationRequestDto).isNotNull();
    }
}