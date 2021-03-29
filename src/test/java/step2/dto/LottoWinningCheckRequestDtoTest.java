package step2.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningCheckRequestDtoTest {

    @DisplayName("LottoConfirmationRequestDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String testInputLottoNumbers = "1, 2, 3, 4, 5, 6";

        // when
        LottoWinningCheckRequestDto requestDto = LottoWinningCheckRequestDto.newInstance(testInputLottoNumbers);

        // then
        assertThat(requestDto).isNotNull();
    }

    @DisplayName("LottoConfirmationRequestDto 인스턴스가 소유한 값을 제대로 반환하는지 테스트")
    @Test
    void 반환() {

        // given
        String testInputLottoNumbers = "1, 2, 3, 4, 5, 6";
        Lotto expected = Lotto.newInstance(testInputLottoNumbers);

        // when
        LottoWinningCheckRequestDto requestDto = LottoWinningCheckRequestDto.newInstance(expected);
        Lotto actual = requestDto.getWinningLotto();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}