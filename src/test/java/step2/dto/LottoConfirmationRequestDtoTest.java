package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("LottoConfirmationRequestDto 인스턴스가 소유한 값을 제대로 반환하는지 테스트")
    @Test
    void 반환() {

        // given
        String testInputLottoNumbers = "1, 2, 3, 4, 5, 6";
        InputLottoNumbers expected = InputLottoNumbers.newInstance(testInputLottoNumbers);

        // when
        LottoConfirmationRequestDto requestDto = LottoConfirmationRequestDto.newInstance(expected);
        InputLottoNumbers actual = requestDto.getInputLottoNumbers();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}