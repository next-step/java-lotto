package step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.LottoNumberOutOfRangeException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 46)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }


    @DisplayName("LottoNumber 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int value = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(value);

        // then
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber 인스턴스 문자열로 생성 여부 테스트")
    @Test
    void 생성_문자열() {
        // given
        String stringValue = "1";
        int intValue = 1;

        // when
        LottoNumber stringLottoNumber = LottoNumber.valueOf(stringValue);
        LottoNumber intLottoNumber = LottoNumber.valueOf(intValue);

        // then
        assertThat(stringLottoNumber).isEqualTo(intLottoNumber);
    }

    @DisplayName("LottoNumber 인스턴스에 0이하의 수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_0이하의수() {
        // given
        int fistValue = 0;
        int secondValue = -1;

        // when
        assertThatThrownBy(() -> {
            LottoNumber.valueOf(fistValue);
            LottoNumber.valueOf(secondValue);
        }).isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗아난 숫자가 입력되었습니다.");

    }

    @DisplayName("LottoNumber 인스턴스에 46이상의 수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_46이상의수() {
        // given
        int value = 46;

        // when
        assertThatThrownBy(() -> LottoNumber.valueOf(value))
                .isInstanceOf(LottoNumberOutOfRangeException.class)
                .hasMessageContaining("로또의 범위를 벗아난 숫자가 입력되었습니다.");

    }

    @DisplayName("LottoNumber 인스턴스가 캐싱된 값을 반환하는 기능 여부 테스트")
    @Test
    void 반환_캐싱된값() {
        // given
        int value = 1;

        // when
        LottoNumber expected = LottoNumber.valueOf(value);
        LottoNumber actual = LottoNumber.valueOf(value);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LottoNumber 인스턴스가 캐싱된 모든 값들을 반환하는지 테스트")
    @Test
    void 반환_캐싱된_모든값() {

        // given
        List<LottoNumber> expected = lottoNumbers;

        // when
        List<LottoNumber> actual = LottoNumber.values();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("LottoNumber 인스턴스가 소유한 값을 반환하는지 테스트")
    @Test
    void 반환_일반소유값() {
        // given
        int expected = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(expected);
        int actual = lottoNumber.getLottoNumber();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}