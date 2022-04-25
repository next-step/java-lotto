package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호들")
class LottoNumbersTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> LottoNumbers.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3))));
    }

    @Test
    @DisplayName("로또 번호들은 필수")
    void instance_null_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> LottoNumbers.from(null));
    }

    @Test
    @DisplayName("로또 번호들은 1개 이상")
    void instance_empty_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("주어진 갯수의 크기 세기")
    void size() {
        assertThat(LottoNumbers.from(Collections.singletonList(LottoNumber.from(1))).size()).isOne();
    }

    @Test
    @DisplayName("중복은 허용되지 않음")
    void size_duplicate() {
        assertThat(LottoNumbers.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(1))).size()).isOne();
    }

    @ParameterizedTest(name = "[{index}] 1,2,3과 {0},{1},{2} 일치하는 번호 갯수를 세면 {3}")
    @DisplayName("1,2,3 로또 번호와 일치하는 숫자 갯수 세기")
    @CsvSource({"4,5,6,0", "3,4,5,1", "2,3,4,2", "1,2,3,3"})
    void matchCount(int first, int second, int third, int expected) {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3)));
        LottoNumbers target = LottoNumbers.from(Arrays.asList(LottoNumber.from(first), LottoNumber.from(second), LottoNumber.from(third)));
        //when, then
        assertThat(lottoNumbers.matchCount(target)).isEqualTo(expected);
    }
}
