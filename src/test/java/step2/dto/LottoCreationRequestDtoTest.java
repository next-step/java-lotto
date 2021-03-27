package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.request.Money;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCreationRequestDtoTest {

    @DisplayName("LottoCreationRequestDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1000;

        // when
        LottoCreationRequestDto lottoCreationRequestDto = LottoCreationRequestDto.newInstance(inputValue);

        // then
        assertThat(lottoCreationRequestDto).isNotNull();
    }

    @DisplayName("LottoCreationRequestDto 인스턴스 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        Money expected = Money.valueOf(1000);

        // when
        LottoCreationRequestDto lottoCreationRequestDto = LottoCreationRequestDto.newInstance(expected);
        Money actual = lottoCreationRequestDto.getMoney();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}