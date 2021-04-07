package step4.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.LottoNumberOutOfRangeException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @DisplayName("LottoNumber 인스턴스 문자열로 생성 여부 테스트")
    @Test
    void 생성_문자열() {
        // given
        String inputValue = "1";

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber 인스턴스에 부적절한 값 주입시 예외처리 여부 테스트")
    @ParameterizedTest(name = "{index}번 째 반복, 주입값 : {0}")
    @ValueSource(ints = {-1, 0, 46})
    void 검증(int inputValue) {

        // when and then
        assertThatThrownBy(() -> LottoNumber.valueOf(inputValue))
                .isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗어난 숫자가 입력되었습니다.");
    }


    @DisplayName("LottoNumber 인스턴스가 캐싱된 값을 반환하는지 테스트")
    @Test
    void 반환_캐싱() {
        // given
        int inputValue = 1;

        // when
        LottoNumber expectedLottoNumber = LottoNumber.valueOf(inputValue);
        LottoNumber actualLottoNumber = LottoNumber.valueOf(inputValue);

        // then
        assertThat(actualLottoNumber).isEqualTo(expectedLottoNumber);
    }

    @DisplayName("LottoNumber 인스턴스가 캐싱된 모든값을 반환하는지 테스트")
    @Test
    void 반환_캐싱된_모든값() {
        // given
        List<LottoNumber> expectedLottoNumbers = IntStream.range(1, 46)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());

        // when
        List<LottoNumber> actualLottoNumbers = LottoNumber.values();

        // then
        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("LottoNumber 인스턴스가 현재 소유한 값을 반환하는지 테스트")
    @Test
    void 반환_햔재소유한값() {
        // given
        int expected = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(expected);
        int actual = lottoNumber.getLottoNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}