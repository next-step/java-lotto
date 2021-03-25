package step2.domain.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.InvalidNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("LottoNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber 인스턴스에 음수 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int inputValue = -1;

        // when and then
        assertThatThrownBy(() -> {
            LottoNumber.valueOf(inputValue);
        }).isInstanceOf(InvalidNumberInputException.class)
                .hasMessageContaining("범위를 벗어난 값이 입력되었습니다.");

    }

    @DisplayName("LottoNumber 인스턴스가 같은 소유한 값을 기준으로 비교 가능한지 테스트")
    @Test
    void 비교_equals() {
        // given
        int inputValue = 1;

        // when
        LottoNumber firstLottoNumber = LottoNumber.valueOf(inputValue);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(firstLottoNumber).isEqualTo(secondLottoNumber);
    }

    @DisplayName("LottoNumber 인스턴스가 같은 소유한 값을 기준으로 같은 주소값을 가지는지 테스트")
    @Test
    void 비교_Equality() {
        // given
        int inputValue = 1;

        // when
        LottoNumber firstLottoNumber = LottoNumber.valueOf(inputValue);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(firstLottoNumber == secondLottoNumber).isTrue();
    }

    @DisplayName("LottoNumber 인스턴스가 소유한 값을 반환하는지에 대한 테스트")
    @Test
    void 반환() {
        // given
        int expected = 1;

        // when
        LottoNumber firstLottoNumber = LottoNumber.valueOf(expected);
        int actual = firstLottoNumber.getLottoNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}