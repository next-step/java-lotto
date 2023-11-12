package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    void lottoNumberCreate(int number) {
        lottoNumber = new LottoNumber(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호_유효성_검사_성공(int number) {
        // given
        lottoNumberCreate(number);
        // when
        int lottoNumber = this.lottoNumber.number();
        // then
        assertThat(lottoNumber).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49, 50})
    void 로또_번호_유효성_검사_실패(int number) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumberCreate(number);
        }).withMessageMatching("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }

    @DisplayName("로또 번호 비교")
    @Nested
    class 로또_번호_비교 {

        @Test
        void 로또_번호_비교_큰_숫자() {
            // given
            lottoNumberCreate(1);
            LottoNumber lottoNumber2 = new LottoNumber(2);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(-1);
        }

        @Test
        void 로또_번호_비교_같은_숫자() {
            // given
            lottoNumberCreate(1);
            LottoNumber lottoNumber2 = new LottoNumber(1);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(0);
        }

        @Test
        void 로또_번호_비교_작은_숫자() {
            // given
            lottoNumberCreate(2);
            LottoNumber lottoNumber2 = new LottoNumber(1);
            // when
            int result = lottoNumber.compareTo(lottoNumber2);
            // then
            assertThat(result).isEqualTo(1);
        }
    }
}
