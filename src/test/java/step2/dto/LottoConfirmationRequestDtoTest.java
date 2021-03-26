package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoConfirmationRequestDtoTest {

    @DisplayName("LottoConfirmationRequestDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String testInputLottoNumbers = "1, 2, 3, 4, 5, 6";

        // when
        LottoConfirmationRequestDto requestDto = LottoConfirmationRequestDto.newInstance(testInputLottoNumbers);

        // then
        assertThat(requestDto).isNotNull();
    }
}